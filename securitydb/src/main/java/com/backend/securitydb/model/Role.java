package com.backend.securitydb.model;

import java.util.Set;

public enum Role {
    ADMIN(Set.of(Permission.READ, Permission.WRITE, Permission.UPDATE)),
    DEVELOPER(Set.of(Permission.DELETE, Permission.READ, Permission.UPDATE,Permission.WRITE)),
    TESTER(Set.of(Permission.WRITE, Permission.READ)),
    MANAGER(Set.of(Permission.WRITE, Permission.READ)),
    SECURITY_ANALYST(Set.of(Permission.UPDATE, Permission.WRITE, Permission.READ)),
    USER(Set.of(Permission.READ, Permission.WRITE));


    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }
    public Set<Permission> getPermissions(){
        return permissions;
    }



}
