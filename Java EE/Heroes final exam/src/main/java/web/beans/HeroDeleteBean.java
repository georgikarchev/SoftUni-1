package web.beans;


import domain.models.service.HeroServiceModel;
import service.HeroService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class HeroDeleteBean extends BaseBean{
    private HeroService heroService;

    public HeroDeleteBean() {
    }

    @Inject
    public HeroDeleteBean(HeroService heroService) {
        this.heroService = heroService;
    }

    public HeroServiceModel getHero(String id) {
        return this.heroService.getHeroById(id);
    }

    public void delete(){
        String id = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("id");
        this.heroService.delete(id);
        this.redirect("/home");
    }

}
