package web.beans;

import domain.models.service.UserServiceModel;
import domain.models.view.FriendProfileViewModel;
import domain.models.view.UserHomeViewModel;
import domain.models.view.UserProfileViewModel;
import org.modelmapper.ModelMapper;
import service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Named("friendsBean")
@RequestScoped
public class FriendsBean extends BaseBean{
    private List<FriendProfileViewModel> models;
    private  UserService userService;
    private  ModelMapper modelMapper;

    public FriendsBean() {
    }

    @Inject
    public  FriendsBean(UserService userService, ModelMapper modelMapper){
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.initModels();
    }

    private void initModels() {
        String id = (String) ((HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false))
                .getAttribute("user-id");

        UserServiceModel loggedInUser = this.userService.getUserById(id);

        this.models = loggedInUser.getFriends()
                .stream()
                .map(u -> this.modelMapper.map(u, FriendProfileViewModel.class))
                .collect(Collectors.toList());;
    }

    public List<FriendProfileViewModel> getModels() {
        return models;
    }

    public void setModels(List<FriendProfileViewModel> models) {
        this.models = models;
    }

    public void unfriend(String id){
        this.redirect("/home");
        UserServiceModel loggedInUser = this.userService.
                getUserById((String) ((HttpSession) FacesContext.getCurrentInstance()
                        .getExternalContext().getSession(true)).getAttribute("user-id"));

        UserServiceModel user = this.userService.getUserById(id);

        this.userService.deleteFriends(loggedInUser.getId(), user.getId());

    }
}
