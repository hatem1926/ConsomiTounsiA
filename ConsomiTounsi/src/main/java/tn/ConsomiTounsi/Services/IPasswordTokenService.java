package tn.ConsomiTounsi.Services;

import tn.ConsomiTounsi.Entities.PasswordResetToken;


public interface IPasswordTokenService {
	
	public PasswordResetToken create (PasswordResetToken PasswordResetToken) ;
}
