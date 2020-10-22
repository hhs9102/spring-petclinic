/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.samples.petclinic.secutiry.Authority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Simple JavaBean domain object representing an person.
 *
 * @author Ken Krebs
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public class User extends BaseEntity implements UserDetails {

    protected String username;
    protected String password;
    protected boolean accountNonExpired;
    protected boolean accountNonLocked;
    protected boolean credentialsNonExpired;
    protected boolean enabled;

    @Column(name = "address")
    @NotEmpty(message="이 값은 null을 허용하지 않습니다.")
    protected String address;

    @Column(name = "city")
    @NotEmpty
    protected String city;

    @Column(name = "telephone")
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    protected String telephone;

    @Column(name = "first_name")
    @NotEmpty
    protected String firstName;

    @Column(name = "last_name")
    @NotEmpty
    protected String lastName;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_AUTHORITY")
    protected List<Authority> authorities;
}
