package web.beans;

import domain.models.service.UserServiceModel;
import domain.models.view.UserHomeViewModel;
import org.modelmapper.ModelMapper;
import repository.BaseRepository;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class HomeBean extends BaseBean{

    private List<UserHomeViewModel> models;

    private UserService userService;
    private ModelMapper modelMapper;

    public HomeBean() {
    }

    @Inject
    public HomeBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.initModels();
    }

    private void initModels() {
        String username = (String) ((HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false))
                .getAttribute("username");

        String id = (String) ((HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false))
                .getAttribute("user-id");

        UserServiceModel loggedInUser = this.userService.getUserById(id);

        this.models = this.userService
                .getAllUsers()
                .stream()
                .filter(u -> !u.getUsername().equals(username) &&
                        !loggedInUser.getFriends()
                                .stream()
                                .map(UserServiceModel::getUsername)
                                .collect(Collectors.toList()).contains(u.getUsername()))
                .map(u -> this.modelMapper.map(u, UserHomeViewModel.class))
                .collect(Collectors.toList());
    }

    public List<UserHomeViewModel> getModels() {
        return models;
    }

    public void setModels(List<UserHomeViewModel> models) {
        this.models = models;
    }

    public void addFriend(String id) throws IOException {
        UserServiceModel loggedInUser = this.userService.
                getUserById((String) ((HttpSession) FacesContext.getCurrentInstance()
                        .getExternalContext().getSession(true)).getAttribute("user-id"));

        UserServiceModel userServiceModel = this.userService.getUserById(id);

        loggedInUser.getFriends().add(userServiceModel);
        userServiceModel.getFriends().add(loggedInUser);

        if (!this.userService.addFriend(loggedInUser)) {
            throw new IllegalArgumentException("Something went wrong!");
        }

        if (!this.userService.addFriend(userServiceModel)) {
            throw new IllegalArgumentException("Something went wrong!");
        }

        this.redirect("/home");
    }
}