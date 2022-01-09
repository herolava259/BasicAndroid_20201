package com.example.jsoninternet;
import java.io.Serializable;
import java.util.*;
import org.json.JSONObject;
public class ProfileModel implements Serializable {



    public ProfileModel(JSONObject jsonObj) throws  Exception{
        id = Integer.parseInt(jsonObj.getString("id"));
        name = jsonObj.getString("name");
        userName = jsonObj.getString("username");
        email = jsonObj.getString("email");
        avt = new Avatar(jsonObj.getJSONObject("avatar"));
        addr = new Address(jsonObj.getJSONObject("address"));
        phone = jsonObj.getString("phone");
        website = jsonObj.getString("website");
        company = new Company(jsonObj.getJSONObject("company"));
    }
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public Avatar getAvt() {
        return avt;
    }

    public void setAvt(Avatar avt) {
        this.avt = avt;
    }

    private Avatar avt;

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    private Address addr;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    private String website;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    private Company company;



    public class Avatar{
        public Avatar(JSONObject jsonObj) throws Exception{
            thumbPath = jsonObj.getString("thumbnail");
            photoPath = jsonObj.getString("photo");
        }
        String thumbPath;
        String photoPath;
    }
    public class Address{
        public Address(JSONObject jsonObj) throws Exception{
            street = jsonObj.getString("street");
            suite = jsonObj.getString("suite");
            city = jsonObj.getString("city");
            zipcode = jsonObj.getString("zipcode");
            geo = new Geo(jsonObj.getJSONObject("geo"));
        }
        String street;
        String suite;
        String city;
        String zipcode;
        Geo geo;
        public class Geo{
            public Geo(JSONObject jsonObj) throws Exception{
                lat = Float.parseFloat(jsonObj.getString("lat"));
                lng = Float.parseFloat(jsonObj.getString("lng"));
            }
            float lat;
            float lng;
        }
    }
    public class Company{
        public Company(JSONObject jsonObj) throws Exception{
            name = jsonObj.getString("name");
            catchPharse = jsonObj.getString("catchPhrase");
            bs = jsonObj.getString("bs");
        }
        String name;
        String catchPharse;
        String bs;
    }
}
