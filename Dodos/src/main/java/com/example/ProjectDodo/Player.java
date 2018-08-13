package com.example.ProjectDodo;

    public class Player {

        private String firstname;
        private String lastname;
        private String image;

        public Player(String firstname, String lastname, String image) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.image = image;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

