package web.beans;

import domain.models.service.UserServiceModel;
import domain.models.view.UserProfileViewModel;
import org.modelmapper.ModelMapper;
import service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named("profileBean")
@RequestScoped
public class ProfileBean extends BaseBean {
    private UserProfileViewModel model;

    private UserService userService;
    private ModelMapper modelMapper;

    public ProfileBean() {
    }

    @Inject
    public ProfileBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.initModel();
    }

    private void initModel() {
        String id = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap().get("id");

        UserServiceModel userServiceModel = this.userService.getUserById(id);

        if (userServiceModel == null) {
            throw new IllegalArgumentException("Something went wrong!");
        }

        this.model = this.modelMapper.map(userServiceModel, UserProfileViewModel.class);
    }

    public UserProfileViewModel getModel() {
        return model;
    }

    public void setModel(UserProfileViewModel model) {
        this.model = model;
    }
    
    public void unfriend(){
        
    }
}
