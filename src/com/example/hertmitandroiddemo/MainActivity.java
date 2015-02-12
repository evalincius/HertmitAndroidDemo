package com.example.hertmitandroiddemo;

import java.io.File;

import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
@SuppressLint("SdCardPath")
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		File file = new File("storage/emulated/0/Download/pizza.owl");
	 	// First, we create an OWLOntologyManager object. The manager will load and save ontologies.
	     OWLOntologyManager m=OWLManager.createOWLOntologyManager();
		// We use the OWL API to load the Pizza ontology.
	     OWLOntology o = null;
		try {
			o = m.loadOntologyFromOntologyDocument(IRI.create(file));
		} catch (OWLOntologyCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     // Now, we instantiate HermiT by creating an instance of the Reasoner class in the package org.semanticweb.HermiT.
	     Reasoner hermit=new Reasoner(o);
	     // Finally, we output whether the ontology is consistent.
	     System.out.println(hermit.isConsistent());
		
	}

	
}
