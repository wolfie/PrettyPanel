package com.github.wolfie.prettypanel;

import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;

@SuppressWarnings("serial")
public class PrettyPanel extends Panel {

	public PrettyPanel() {
		setStyleName("w-prettypanel");
	}

	public PrettyPanel(final Component content) {
		super(content);
	}

	public PrettyPanel(final String caption, final Component content) {
		super(caption, content);
	}

	public PrettyPanel(final String caption) {
		super(caption);
	}
}
