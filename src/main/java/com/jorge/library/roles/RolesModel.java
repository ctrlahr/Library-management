package com.jorge.library.roles;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "tb_roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolesModel implements GrantedAuthority {

    @Id
    private Integer id;
    private String name;


    @Override
    public @Nullable String getAuthority() {
        return name;
    }
}
