package com.happycheeseburger.rigbuilder;

import java.math.BigDecimal;
import java.util.*;

public class Rig
{
	String rigName;
    Map<String, Integer> parts;

    public Rig(String name, 
    		int alloyedTritaniumBars, 
    		int armorPlates, 
    		int brokenDroneTranceivers, 
    		int burnedLogicCircuits, 
    		int charredMicroCircuits, 
    		int conductivePolymer, 
            int contaminatedLorentzFluid, 
            int contaminatedNaniteCompound, 
            int damagedArtificialNeuralNetwork, 
            int defectiveCurrentPump, 
            int friedInterfaceCircuit, 
            int malfunctioningShieldEmitter, 
            int meltedCapacitorConsole, 
            int scorchedTelemetryProcessor, 
            int smashedTriggerUnit, 
            int tangledPowerConduit, 
            int thrusterConsole, 
            int tripperPowerCircuit,
            int wardConsole)
    {
        parts = new HashMap<String, Integer>();
        rigName = name;
        if(alloyedTritaniumBars != 0){
            parts.put("alloyedTritaniumBars".toLowerCase(), Integer.valueOf(alloyedTritaniumBars));
        }
        if(armorPlates != 0){
            parts.put("armorPlates".toLowerCase(), Integer.valueOf(armorPlates));
        }
        if(brokenDroneTranceivers != 0){
            parts.put("brokenDroneTranceivers".toLowerCase(), Integer.valueOf(brokenDroneTranceivers));
        }
        if(burnedLogicCircuits != 0){
            parts.put("burnedLogicCircuits".toLowerCase(), Integer.valueOf(burnedLogicCircuits));
        }
        if(charredMicroCircuits != 0){
            parts.put("charredMicroCircuits".toLowerCase(), Integer.valueOf(charredMicroCircuits));
        }
        if(conductivePolymer != 0){
            parts.put("conductivePolymer".toLowerCase(), Integer.valueOf(conductivePolymer));
        }
        if(contaminatedLorentzFluid != 0){
            parts.put("contaminatedLorentzFluid".toLowerCase(), Integer.valueOf(contaminatedLorentzFluid));
        }
        if(contaminatedNaniteCompound != 0){
            parts.put("contaminatedNaniteCompound".toLowerCase(), Integer.valueOf(contaminatedNaniteCompound));
        }
        if(damagedArtificialNeuralNetwork != 0){
            parts.put("damagedArtificialNeuralNetwork".toLowerCase(), Integer.valueOf(damagedArtificialNeuralNetwork));
        }
        if(defectiveCurrentPump != 0){
            parts.put("defectiveCurrentPump".toLowerCase(), Integer.valueOf(defectiveCurrentPump));
        }
        if(friedInterfaceCircuit != 0){
            parts.put("friedInterfaceCircuit".toLowerCase(), Integer.valueOf(friedInterfaceCircuit));
        }
        if(malfunctioningShieldEmitter != 0){
            parts.put("malfunctioningShieldEmitter".toLowerCase(), Integer.valueOf(malfunctioningShieldEmitter));
        }
        if(meltedCapacitorConsole != 0){
            parts.put("meltedCapacitorConsole".toLowerCase(), Integer.valueOf(meltedCapacitorConsole));
        }
        if(scorchedTelemetryProcessor != 0){
            parts.put("scorchedTelemetryProcessor".toLowerCase(), Integer.valueOf(scorchedTelemetryProcessor));
        }
        if(smashedTriggerUnit != 0){
            parts.put("smashedTriggerUnit".toLowerCase(), Integer.valueOf(smashedTriggerUnit));
        }
        if(tangledPowerConduit != 0){
            parts.put("tangledPowerConduit".toLowerCase(), Integer.valueOf(tangledPowerConduit));
        }
        if(thrusterConsole != 0){
            parts.put("thrusterConsole".toLowerCase(), Integer.valueOf(thrusterConsole));
        }
        if(tripperPowerCircuit != 0){
            parts.put("tripperPowerCircuit".toLowerCase(), Integer.valueOf(tripperPowerCircuit));
        }
        if(wardConsole != 0){
            parts.put("wardConsole".toLowerCase(), Integer.valueOf(wardConsole));
        }
    }

    public Rig(String name, Map<String, Integer> parts)
    {
        this.rigName = name;
        this.parts = parts;
    }

    public String getRigName()
    {
        return rigName;
    }

    public void setRigName(String rigName)
    {
        this.rigName = rigName;
    }

    public Map<String, Integer> getParts()
    {
        return parts;
    }

    public void setParts(Map<String, Integer> parts)
    {
        this.parts = parts;
    }

    public Construction howManyCanIMake(Rig cost, Map<String, String> settings)
    {
        Set<String> costKeys = cost.getParts().keySet();
        Integer maximumICanMake = Integer.valueOf(-1);
        for(String partName : costKeys)
        {
            BigDecimal stock = new BigDecimal(((Integer)parts.get(partName)).intValue());
            BigDecimal efficiencyFactor = (new BigDecimal(settings.get("efficiency"))).multiply(new BigDecimal("0.05"));
            BigDecimal efficiencyMultiplier = (new BigDecimal("1.25")).subtract(efficiencyFactor);
            BigDecimal required = (new BigDecimal(((Integer)cost.getParts().get(partName)).intValue())).multiply(efficiencyMultiplier);
            BigDecimal iCanMakeThisMany = stock.divide(required, 1);
            if(maximumICanMake.intValue() == -1)
                maximumICanMake = Integer.valueOf(iCanMakeThisMany.intValue());
            else
            if(maximumICanMake.intValue() > iCanMakeThisMany.intValue())
                maximumICanMake = Integer.valueOf(iCanMakeThisMany.intValue());
        }

        return new Construction(cost.getRigName(), maximumICanMake.intValue());
    }

    
}
