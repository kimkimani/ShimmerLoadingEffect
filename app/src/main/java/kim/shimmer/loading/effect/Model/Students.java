package kim.shimmer.loading.effect.Model;

public class Students {
    private String name;
    private String college;
    private String specialization ;
    private String description ;
    private String profile_img ;

    public Students() {
    }

    public Students(String name, String college, String specialization, String description, String profile_img) {
        this.name = name;
        this.college = college;
        this.specialization = specialization;
        this.description = description;
        this.profile_img = profile_img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getCollege() {
        return college;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getProfile_img() {
        return profile_img;
    }

    public String getDescription() {
        return description;
    }
}
