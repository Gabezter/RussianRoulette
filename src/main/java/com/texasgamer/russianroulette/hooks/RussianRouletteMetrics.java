package com.texasgamer.russianroulette.hooks;

import java.io.IOException;
import java.util.logging.Logger;

import com.texasgamer.russianroulette.RussianRoulette;
import com.texasgamer.russianroulette.RussianRouletteStats;

public class RussianRouletteMetrics {
	
	public static final Logger logger = Logger.getLogger("Minecraft");
	
	public static RussianRouletteStats metricsStats;
	
	public static void setupMetrics(RussianRoulette instance, RussianRouletteStats stats) {
		try {
			metricsStats = stats;
		    Metrics metrics = new Metrics();
		    
		    metrics.addCustomData(instance, new Metrics.Plotter() {
		        @Override
		        public String getColumnName() {
		            return "Total Victims";
		        }

		        @Override
		        public int getValue() {
		            return metricsStats.getKicks();
		        }
		    });
		    
		    metrics.addCustomData(instance, new Metrics.Plotter() {
		        @Override
		        public String getColumnName() {
		            return "Revolvers";
		        }

		        @Override
		        public int getValue() {
		            return metricsStats.getRevolvers();
		        }
		    });
		    			    
		    metrics.addCustomData(instance, new Metrics.Plotter() {
		        @Override
		        public String getColumnName() {
		            return "Nukes";
		        }

		        @Override
		        public int getValue() {
		            return metricsStats.getNukes();
		        }
		    });
		    
		    metrics.addCustomData(instance, new Metrics.Plotter() {
		        @Override
		        public String getColumnName() {
		            return "MOABs";
		        }

		        @Override
		        public int getValue() {
		            return metricsStats.getMOABS();
		        }
		    });
		    
		    metrics.beginMeasuringPlugin(instance);
		    logger.info("[RussianRoulette] Registered Metrics hook");
		} catch (IOException e) {
			logger.warning("[RussianRoulette] Failed to register Metrics hook");
		}
	}
}
