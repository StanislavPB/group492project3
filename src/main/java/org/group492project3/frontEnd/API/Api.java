package org.group492project3.frontEnd.API;

import org.group492project3.backEnd.dto.Response;

public class Api {


    public Response<User, String> authorisation(String login, String password) {
        //new User(login, password);
        return new Response<>(null, false, null); //plug
    }

    public Response<NewUser, String> registration(String login, String password, String firstName, String secondName) {
       // new NewUser(login, password, firstName, secondName);
        return new Response<>(null, false, null); //plug
    }

    public static class User {
        private String login;
        private String password;

        public User(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }
    }

    public static class NewUser {
        private String login;
        private String password;
        private String firstName;
        private String secondName;

        public NewUser(String login, String password, String firstName, String secondName) {
            this.login = login;
            this.password = password;
            this.firstName = firstName;
            this.secondName = secondName;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getSecondName() {
            return secondName;
        }
    }
}
