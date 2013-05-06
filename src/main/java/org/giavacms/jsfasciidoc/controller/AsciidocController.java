package org.giavacms.jsfasciidoc.controller;

import java.io.Serializable;
import java.util.Collections;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.internal.JRubyAsciidoctor;

@Named
@SessionScoped
public class AsciidocController implements Serializable {
	private static final long serialVersionUID = 1L;

	Asciidoctor asciidoctor;

	public AsciidocController() {
		System.out.println("creo AsciidocController");
		asciidoctor = JRubyAsciidoctor.create();
	}

	public String getHtml() {
		String rendered = asciidoctor.render("*This* is it.",
				Collections.EMPTY_MAP);
		System.out.println(rendered);
		return rendered;
	}

	public static void main(String[] args) {
		AsciidocController a = new AsciidocController();
		a.getHtml();
	}
}
