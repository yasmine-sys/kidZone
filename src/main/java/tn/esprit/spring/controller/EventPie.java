package tn.esprit.spring.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.EventEntity;
import tn.esprit.spring.interfaces.IEventService;


@Named("eventPie")
@ViewScoped
public class EventPie {

		@Autowired
		private IEventService eventService;	
		private PieChartModel model;
		private List<EventEntity> listEvents;
	  public void setModel(PieChartModel model) {
		this.model = model;
	}
	  

	public EventPie() {
	}


	@PostConstruct
	  public void init() {
		listEvents = eventService.getAllEvents();
			int numbActif = 0;
			int numNonActif =0;
			for (int i=0; i<listEvents.size();i++){
				if(listEvents.get(i).getNbrPlaces()>200){

				numbActif++;
			}
			else {
				
				numNonActif++;
			}
		
			}
			model = new PieChartModel();
			model.set("Events over 200 capacity", numbActif);
			model.set("Events under 200 capacity", numNonActif);
	      //followings are some optional customizations:
	      //set title

			//set legend position to 'e' (east), other values are 'w', 's' and 'n'
	      model.setLegendPosition("e");
	      //enable tooltips
	      model.setShowDatatip(true);
	      //show labels inside pie chart
	      model.setShowDataLabels(true);
	      //show label text  as 'value' (numeric) , others are 'label', 'percent' (default). Only one can be used.
	      model.setDataFormat("value");
	      //format: %d for 'value', %s for 'label', %d%% for 'percent'
	      model.setDataLabelFormatString("%d");
	      //pie sector colors
	      model.setSeriesColors("FF5733,33FFF1,faa,ffa,aff,faf,ddd");
	  }

	  public PieChartModel getModel() {
	      return model;
	  }
	}