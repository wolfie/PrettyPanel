package com.github.wolfie.prettypanel.client;

import com.github.wolfie.prettypanel.PrettyPanel;
import com.vaadin.client.ui.panel.PanelConnector;
import com.vaadin.shared.ui.Connect;

@Connect(PrettyPanel.class)
@SuppressWarnings("serial")
public class PrettyPanelConnector extends PanelConnector {
	@Override
	public PrettyPanelWidget getWidget() {
		return (PrettyPanelWidget) super.getWidget();
	}
}
