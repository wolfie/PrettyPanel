package com.github.wolfie.prettypanel.client;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.Util;
import com.vaadin.client.ui.VPanel;

public class PrettyPanelWidget extends VPanel {

	private final Element containerElement;

	public PrettyPanelWidget() {
		containerElement = DOM.createDiv();
		final Element superContainer = super.getContainerElement();
		superContainer.appendChild(containerElement);
		superContainer.getStyle().setPosition(Position.RELATIVE);
		DOM.sinkEvents(getElement(), Event.ONMOUSEOVER | Event.ONMOUSEOUT);
	}

	void checkForOverflow() {
		final Element superContainer = PrettyPanelWidget.super
				.getContainerElement();
		if (superContainer.getOffsetHeight() < superContainer.getScrollHeight()) {
			containerElement.getStyle().setRight(Util.getNativeScrollbarSize(),
					Unit.PX);
		}
	}

	@Override
	public void onBrowserEvent(final Event event) {
		super.onBrowserEvent(event);
		final Element c = super.getContainerElement();

		final int type = DOM.eventGetType(event);
		if (type == Event.ONMOUSEOVER) {
			final int scrollTop = c.getScrollTop();
			containerElement.getStyle().setRight(0, Unit.PX);
			c.getStyle().setOverflowY(Overflow.AUTO);
			c.setScrollTop(scrollTop);
		} else if (type == Event.ONMOUSEOUT) {
			final int scrollTop = c.getScrollTop();
			checkForOverflow();
			c.getStyle().setOverflowY(Overflow.HIDDEN);
			c.setScrollTop(scrollTop);
		}
	}

	@Override
	public void setWidget(final IsWidget w) {
		super.setWidget(w);
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				checkForOverflow();
			}
		});
	}

	@Override
	public void setWidget(final Widget w) {
		super.setWidget(w);
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				checkForOverflow();
			}
		});
	}

	@Override
	protected Element getContainerElement() {
		return containerElement;
	}
}
