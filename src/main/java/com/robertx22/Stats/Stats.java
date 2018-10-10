package com.robertx22.Stats;
import java.util.HashMap;
import java.util.Hashtable;

import com.robertx22.Enums.StatRefs;
import com.robertx22.Stats.Mods.*;
import com.robertx22.Stats.Types.*;

public class Stats {	
	
	
	public static HashMap<StatRefs, Stat> Classes = new HashMap<StatRefs, Stat>() {{
	    put(StatRefs.Health, new Health());
	    put(StatRefs.Armor, new Armor());
		  
	    
	}};	
	
	public static HashMap<StatRefs, StatMod> Mods = new HashMap<StatRefs, StatMod>() {{
	    put(StatRefs.Health, new HealthMod());	   
		  
	    
	}};	
	
}
