package com.github.wolfie.prettypanel;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("prettypanel")
public class PrettyPanelDemo extends UI {
	private static final String LIPSUM = "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus "
			+ "vulputate pulvinar nibh eget blandit. Sed id ipsum luctus, "
			+ "scelerisque est non, ultricies quam. Etiam eu tempor augue, eget "
			+ "cursus lorem. Quisque auctor sem vel dictum dapibus. Praesent ipsum "
			+ "mi, iaculis vitae elit in, mattis cursus magna. Aenean lobortis dolor "
			+ "non ligula hendrerit, nec imperdiet orci bibendum. Proin laoreet "
			+ "libero sem, in luctus mi fermentum in. Quisque pharetra, ipsum quis "
			+ "posuere dignissim, leo nisl dictum turpis, vitae tristique leo metus "
			+ "ac dolor. Integer id consequat odio. Morbi tincidunt magna et felis "
			+ "dignissim rhoncus. Quisque blandit eu magna at dapibus. "
			+ "</p><p>"
			+ "Donec placerat venenatis accumsan. Nulla quis metus nec felis dictum "
			+ "pellentesque non sit amet nunc. Quisque in mi id velit lacinia "
			+ "laoreet. In hac habitasse platea dictumst. Pellentesque mattis augue "
			+ "et dolor malesuada elementum. Maecenas eu scelerisque sem. Proin non "
			+ "mollis mi, ac sagittis urna. Vestibulum id elit non tortor interdum "
			+ "ultricies. "
			+ "</p><p>"
			+ "Vestibulum posuere sagittis nulla, quis feugiat nibh feugiat "
			+ "faucibus. Donec euismod malesuada nisl, pretium rhoncus est gravida "
			+ "sodales. Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
			+ "Pellentesque varius, nisl vel pulvinar scelerisque, felis sem dapibus "
			+ "dolor, venenatis adipiscing urna metus id lorem. Cras vitae tortor "
			+ "sed erat porta pulvinar. Cras non adipiscing sem, nec sollicitudin "
			+ "felis. Curabitur nec nisl id massa pellentesque tempus. Donec "
			+ "convallis scelerisque ultrices. Suspendisse potenti. Maecenas in "
			+ "magna ante. Nunc interdum risus et neque sodales, eget ultrices purus "
			+ "tempus. "
			+ "</p><p>"
			+ "Vivamus a nulla at lacus sagittis viverra non vel velit. Cras non "
			+ "lectus eget lectus tempor tincidunt. Sed ut convallis lorem. Aliquam "
			+ "non enim consectetur, fringilla ligula in, faucibus ligula. Nullam "
			+ "interdum sapien at sapien interdum, ac laoreet massa scelerisque. In "
			+ "porta semper tortor, sit amet tempus tortor porttitor vitae. Etiam "
			+ "sagittis, enim ut sagittis tincidunt, nunc diam pharetra sem, ut "
			+ "placerat lacus turpis eu urna. Vestibulum viverra nulla egestas "
			+ "libero scelerisque blandit. Aliquam erat volutpat. Ut at posuere "
			+ "lorem, at interdum ligula. Cum sociis natoque penatibus et magnis dis "
			+ "parturient montes, nascetur ridiculus mus. Morbi ut leo sed leo "
			+ "eleifend venenatis nec ut risus. Nam at justo elit. Duis gravida "
			+ "ullamcorper libero sit amet suscipit. "
			+ "</p><p>"
			+ "Fusce non massa adipiscing, pellentesque ante eu, vulputate lectus. "
			+ "Aliquam porta mollis ipsum sed vestibulum. In nec iaculis mauris, et "
			+ "vulputate lorem. Suspendisse volutpat, magna vitae semper commodo, "
			+ "felis eros ullamcorper nisl, vitae auctor tortor neque quis mi. "
			+ "Suspendisse consectetur, quam iaculis tempus rhoncus, libero felis "
			+ "ultricies turpis, et tincidunt eros mi et enim. Integer congue dui "
			+ "sit amet euismod viverra. Etiam volutpat, tellus a consequat viverra, "
			+ "lectus massa iaculis libero, ac egestas augue tellus non justo. "
			+ "Aenean aliquet iaculis lectus, sed venenatis elit volutpat quis. "
			+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam "
			+ "pharetra metus ipsum, et auctor tellus placerat in.</p>";

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = PrettyPanelDemo.class, widgetset = "com.github.wolfie.prettypanel.PrettypanelWidgetset")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(final VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSpacing(true);
		setContent(layout);

		final PrettyPanel prettypanelScroll = new PrettyPanel();
		prettypanelScroll.setWidth("400px");
		prettypanelScroll.setHeight("400px");
		prettypanelScroll.setContent(new Label(LIPSUM, ContentMode.HTML));
		layout.addComponent(prettypanelScroll);

		final PrettyPanel prettypanelNoScroll = new PrettyPanel();
		prettypanelNoScroll.setContent(new Label(LIPSUM.split("</p><p>")[0]
				+ "</p>", ContentMode.HTML));
		prettypanelNoScroll.setWidth("400px");
		prettypanelNoScroll.setHeight("400px");
		layout.addComponent(prettypanelNoScroll);
	}
}