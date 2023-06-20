package com.javarush.jira.profile.internal;

import com.javarush.jira.common.HasId;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * id is the same as User.id (not autogenerate)
 */
@Entity
@Table(name = "profile")
@NoArgsConstructor
@Getter
@Setter
public class Profile implements HasId {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(name = "last_failed_login")
    private LocalDateTime lastFailedLogin;

    @Column(name = "mail_notifications")
    private long mailNotifications;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "id", updatable = false)
    private Set<Contact> contacts = new HashSet<>();

    public Profile(long id) {
        this.id = id;
    }

    public boolean hasNotification(long mask) {
        return (mailNotifications & mask) != 0;
    }

    @Override
    public String toString() {
        return "Profile: " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profile profile = (Profile) o;

        if (mailNotifications != profile.mailNotifications) return false;
        if (!Objects.equals(id, profile.id)) return false;
        if (!Objects.equals(lastLogin, profile.lastLogin)) return false;
        if (!Objects.equals(lastFailedLogin, profile.lastFailedLogin))
            return false;
        return Objects.equals(contacts, profile.contacts);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
        result = 31 * result + (lastFailedLogin != null ? lastFailedLogin.hashCode() : 0);
        result = 31 * result + (int) (mailNotifications ^ (mailNotifications >>> 32));
        result = 31 * result + (contacts != null ? contacts.hashCode() : 0);
        return result;
    }
}
