package test.spring.data.infra;

import org.springframework.data.domain.AuditorAware;

import test.spring.data.domain.User;


/**
 * Dummy implementation of {@link AuditorAware}. It will return the configured
 * {@link AuditableUser} as auditor on every call to
 * {@link #getCurrentAuditor()}. Normally you would access the applications
 * security subsystem to return the current user.
 * 
 * @author Oliver Gierke
 */
public class AuditorAwareImpl implements AuditorAware<User> {

    private User auditor;


    /**
     * @param auditor the auditor to set
     */
    public void setAuditor(User auditor) {

        this.auditor = auditor;
    }


    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.data.domain.AuditorAware#getCurrentAuditor()
     */
    public User getCurrentAuditor() {

        return auditor;
    }

}
