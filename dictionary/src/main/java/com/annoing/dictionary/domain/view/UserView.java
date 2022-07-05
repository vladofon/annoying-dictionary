package com.annoing.dictionary.domain.view;

public final class UserView {

	public interface QuickView {
	}

	public interface ProfileView extends QuickView {
	}

	public interface FullView extends ProfileView {
	}
}
