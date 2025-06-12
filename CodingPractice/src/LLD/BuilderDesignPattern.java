package LLD;
class User{
    // required parameters
    private final String name;
    private final String age;
    private final String Gender;

    // optional parameters
    private final String language;
    private final String origin;

    public User(UserBuilder user) {
        this.name = user.name;
        this.age = user.age;
        this.Gender = user.gender;
        this.language = user.language;
        this.origin = user.origin;
    }

    public void details()
    {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + Gender);
        System.out.println("Language: " + language);
        System.out.println("Origin: " + origin);
    }

    public static class UserBuilder{
        private final String name;
        private final String age;
        private final String gender;

        private String language;
        private String origin;

        public UserBuilder(String name, String age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }
        public UserBuilder SetLanguage(String language) {
            this.language = language;
            return this;
        }

        public UserBuilder SetOrigin(String origin) {
            this.origin = origin;
            return this;
        }
        public User build()
        {
            return new User(this);
        }
    }
}
public class BuilderDesignPattern {

    public static void main(String[] args) {
        User A = new User.UserBuilder("Suman Biswas", "29", "Male").
                SetLanguage("English").
                SetOrigin("India").
                build();
        A.details();
    }
}
