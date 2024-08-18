package dev.fakestore.service;

public interface IAuthService {
    /**
     * Authentication method, takes username and returns jwt
     *
     * @param user username
     *
     * @return Object jwt
     */
    public String auth(String user);
}
