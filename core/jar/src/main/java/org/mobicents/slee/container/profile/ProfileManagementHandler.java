package org.mobicents.slee.container.profile;

import javax.slee.CreateException;
import javax.slee.SLEEException;
import javax.slee.profile.ProfileContext;
import javax.slee.profile.ProfileID;
import javax.slee.profile.ProfileVerificationException;
import javax.slee.usage.UnrecognizedUsageParameterSetNameException;

import org.apache.log4j.Logger;

/**
 * 
 * ProfileManagementHandler.java
 * 
 * <br>
 * Project: mobicents <br>
 * 3:26:16 PM Apr 3, 2009 <br>
 * 
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class ProfileManagementHandler {

	private static Logger logger = Logger
			.getLogger(ProfileManagementHandler.class);

	public static boolean isProfileDirty(ProfileObject profileObject) {
		if (logger.isDebugEnabled()) {
			logger.info("[isProfileDirty] @ " + profileObject);
		}

		return profileObject.getProfileEntity().isDirty();
	}

	public static boolean isProfileValid(ProfileObject profileObject,
			ProfileID profileId) throws NullPointerException, SLEEException {
		if (logger.isDebugEnabled()) {
			logger.info("[isProfileValid(" + profileId + ")] @ "
					+ profileObject);
		}

		// FIXME: Alexandre: Validate the profile
		return true;
	}

	public static void markProfileDirty(ProfileObject profileObject) {
		if (logger.isDebugEnabled()) {
			logger.info("[markProfileDirty] @ " + profileObject);
		}

		profileObject.getProfileEntity().markAsDirty();
	}

	public static void profileInitialize(ProfileObject profileObject) {
		
	}

	public static void profileLoad(ProfileObject profileObject) {
		
	}

	public static void profileStore(ProfileObject profileObject) {
		
	}

	public static void profileVerify(ProfileObject profileObject)
			throws ProfileVerificationException {
	
	}

	public static void profileActivate(ProfileObject profileObject) {
	
	}

	public static void profilePassivate(ProfileObject profileObject) {
	
	}

	public static void profilePostCreate(ProfileObject profileObject)
			throws CreateException {
	
	}

	public static void profileRemove(ProfileObject profileObject) {
		
	}

	public static void setProfileContext(ProfileObject profileObject,
			ProfileContext profileContext) {
		
	}

	public static void unsetProfileContext(ProfileObject profileObject) {
		
	}

	// Usage methods. Here we can be static for sure. Rest must be tested.
	public static Object getProfileUsageParam(ProfileObject profileObject,
			String name) throws UnrecognizedUsageParameterSetNameException {
		if (logger.isDebugEnabled()) {
			logger.info("[getProfileUsageParam(" + name + ")] @ "
					+ profileObject);
		}

		if (name == null) {
			throw new NullPointerException(
					"UsageParameterSet name must not be null.");
		}

		ProfileTableConcrete profileTableConcrete = profileObject
				.getProfileTableConcrete();

		return profileTableConcrete.getProfileTableUsageMBean()
				.getInstalledUsageParameterSet(name);
	}

	public static Object getProfileDefaultUsageParam(
			ProfileObject profileObject) {
		if (logger.isDebugEnabled()) {
			logger.info("[getProfileDefaultUsageParam] @ "
					+ profileObject);
		}

		ProfileTableConcrete profileTableConcrete = profileObject
				.getProfileTableConcrete();

		return profileTableConcrete.getProfileTableUsageMBean()
				.getInstalledUsageParameterSet(null);
	}

	private static ClassLoader switchContextClassLoader(
			ClassLoader newClassLoader) {
		Thread t = Thread.currentThread();
		ClassLoader oldClassLoader = t.getContextClassLoader();
		t.setContextClassLoader(newClassLoader);

		return oldClassLoader;
	}

}
