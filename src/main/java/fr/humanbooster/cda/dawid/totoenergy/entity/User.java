package fr.humanbooster.cda.dawid.totoenergy.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.cda.dawid.totoenergy.utils.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class User implements UserDetails {

    @Id
    @JsonView(JsonViews.ViewsUserDetails.class)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @JsonView(JsonViews.ViewsUserDetails.class)
    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @JsonView(JsonViews.ViewsUserMinimal.class)
    @Column(nullable = false)
    private String lastName;

    @JsonView(JsonViews.ViewsUserMinimal.class)
    @Column(nullable = false)
    private String firstName;

    @JsonView(JsonViews.ViewsUserDetails.class)
    private String phone;

    @JsonView(JsonViews.ViewsUserDetails.class)
    private LocalDate birthDate;

    private String activationCode;

    private LocalDateTime ActivationCodeSentAt;

    @OneToMany(mappedBy = "user")
    private List<UserLocalisation> userLocalisations = new ArrayList<>();

    @OneToMany(mappedBy = "owner")
    private List<Localisation> localisations = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Booking> bookings = new ArrayList<>();

    @OneToMany(mappedBy = "userFrom")
    private List<UserReview> userReviewsFrom = new ArrayList<>();

    @OneToMany(mappedBy = "userTo")
    private List<UserReview> userReviewsTo = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Favorite> favorites = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean isVerified() {
        return activationCode == null;
    }
}