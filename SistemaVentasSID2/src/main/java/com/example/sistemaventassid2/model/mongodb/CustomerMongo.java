package com.example.sistemaventassid2.model.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "customers")
public class CustomerMongo {
    @Id
    private String id;

    private Long customerId;
    private List<Child> children;
    private BirthPlace birthPlace;
    private Location location;
    private List<String> hobbies;

    private List<String> sports;
    private MaritalStatus maritalStatus;
    private List<String> productCategories;

    public CustomerMongo(String id,Long customerId, List<Child> children, BirthPlace birthPlace, Location location, List<String> hobbies, List<String> sports, MaritalStatus maritalStatus, List<String> productCategories) {
        this.id = id;
        this.customerId = customerId;
        this.children = children;
        this.birthPlace = birthPlace;
        this.location = location;
        this.hobbies = hobbies;
        this.sports = sports;
        this.maritalStatus = maritalStatus;
        this.productCategories = productCategories;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public BirthPlace getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(BirthPlace birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public List<String> getSports() {
        return sports;
    }

    public void setSports(List<String> sports) {
        this.sports = sports;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public List<String> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<String> productCategories) {
        this.productCategories = productCategories;
    }

    public static class Child {
        private String name;
        private String birthDate;
        private String gender;
        private boolean studies;
        private List<String> videoGames;

        public Child(String name, String birthDate, String gender, boolean studies, List<String> videoGames) {
            this.name = name;
            this.birthDate = birthDate;
            this.gender = gender;
            this.studies = studies;
            this.videoGames = videoGames;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public boolean isStudies() {
            return studies;
        }

        public void setStudies(boolean studies) {
            this.studies = studies;
        }

        public List<String> getVideoGames() {
            return videoGames;
        }

        public void setVideoGames(List<String> videoGames) {
            this.videoGames = videoGames;
        }
    }

    public static class BirthPlace {
        private String city;
        private String state;
        private String country;

        public BirthPlace(String city, String state, String country) {
            this.city = city;
            this.state = state;
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }

    public static class Location {
        private String city;
        private String region;
        private String country;
        private String postalCode;

        public Location(String city, String region, String country, String postalCode) {
            this.city = city;
            this.region = region;
            this.country = country;
            this.postalCode = postalCode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }
    }

    public static class MaritalStatus {
        private String current;
        private List<StatusHistory> history;

        public MaritalStatus(String current, List<StatusHistory> history) {
            this.current = current;
            this.history = history;
        }

        public String getCurrent() {
            return current;
        }

        public void setCurrent(String current) {
            this.current = current;
        }

        public List<StatusHistory> getHistory() {
            return history;
        }

        public void setHistory(List<StatusHistory> history) {
            this.history = history;
        }
    }

    public static class StatusHistory {
        private String status;
        private String date;

        public StatusHistory(String status, String date) {
            this.status = status;
            this.date = date;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}
