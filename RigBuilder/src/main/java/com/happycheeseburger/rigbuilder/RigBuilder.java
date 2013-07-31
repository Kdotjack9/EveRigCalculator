// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RigBuilder.java

package com.happycheeseburger.rigbuilder;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import java.io.*;
import java.util.*;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.happycheeseburger.rigbuilder:
//            Rig, Construction

public class RigBuilder
{

    public RigBuilder()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        Map<String, String> settings = parseSettings();
        
        if(StringUtils.isBlank((CharSequence)settings.get("inputFile"))){
            settings.put("inputFile", "input.csv");
        }
        
        if(StringUtils.isBlank((CharSequence)settings.get("outputFile"))){
            settings.put("outputFile", "output.csv");
        }
        
        if(StringUtils.isBlank((CharSequence)settings.get("efficiency"))){
            settings.put("efficiency", "5");
        }
        
        Rig invintory = parseInvintory(settings);
        
        List<Rig> rigs = buildRigMaterialsList();
        
        List<Construction> construction = howManyRigsCanIMake(invintory, rigs, settings);
        
        outputConstructionToFile(construction, settings);
    }

    private static Map<String, String> parseSettings()
    {
        Map<String, String> map = new HashMap<String, String>();
        try
        {
            CSVReader reader = new CSVReader(new FileReader("settings.csv"));
            String nextLine[];
            while((nextLine = reader.readNext()) != null) 
                map.put(nextLine[0], nextLine[1]);
        }
        catch(IOException ie)
        {
            System.out.println("No Settings File Found");
        }
        return map;
    }

    private static Rig parseInvintory(Map<String, String> settings)
        throws IOException
    {
        Map<String, Integer> parts = new HashMap<String, Integer>();
        CSVReader reader = new CSVReader(new FileReader(settings.get("inputFile")));
        String nextLine[];
        while((nextLine = reader.readNext()) != null) 
        {
            Integer number = null;
            if(StringUtils.isNumeric(nextLine[1])){
                number = Integer.valueOf(nextLine[1]);
            } else {
                number = Integer.valueOf(0);
            }
            parts.put(nextLine[0].toLowerCase(), number);
        }
        Rig rig = new Rig("Inventory", parts);
        return rig;
    }

    private static List<Rig> buildRigMaterialsList()
    {
        List<Rig> rigs = new ArrayList<Rig>();
        rigs.add(new Rig("Large Anti-EM Pump I", 0, 72, 0, 0, 0, 0, 0, 44, 0, 0, 83, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Anti-EM Pump I", 0, 14, 0, 0, 0, 0, 0, 9, 0, 0, 17, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Anti-EM Pump I", 0, 3, 0, 0, 0, 0, 0, 2, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Anti-Explosive Pump I", 0, 72, 0, 0, 0, 0, 0, 44, 0, 0, 83, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Anti-Explosive Pump I", 0, 14, 0, 0, 0, 0, 0, 9, 0, 0, 17, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Anti-Explosive Pump I", 0, 3, 0, 0, 0, 0, 0, 2, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Anti-Kinetic Pump I", 0, 72, 0, 0, 0, 0, 0, 44, 0, 0, 83, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Anti-Kinetic Pump I", 0, 14, 0, 0, 0, 0, 0, 9, 0, 0, 17, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Anti-Kinetic Pump I", 0, 3, 0, 0, 0, 0, 0, 2, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Anti-Thermic Pump I", 0, 72, 0, 0, 0, 0, 0, 44, 0, 0, 83, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Anti-Thermic Pump I", 0, 14, 0, 0, 0, 0, 0, 9, 0, 0, 17, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Anti-Thermic Pump I", 0, 3, 0, 0, 0, 0, 0, 2, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Auxiliary Nano Pump I", 0, 88, 0, 0, 0, 0, 0, 66, 0, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Auxiliary Nano Pump I", 0, 18, 0, 0, 0, 0, 0, 13, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Auxiliary Nano Pump I", 0, 4, 0, 0, 0, 0, 0, 3, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Nanobot Accelerator Pump I", 0, 88, 0, 0, 0, 0, 0, 66, 0, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Nanobot Accelerator Pump I", 0, 18, 0, 0, 0, 0, 0, 13, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Nanobot Accelerator Pump I", 0, 4, 0, 0, 0, 0, 0, 3, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Remote Repair Augmentor Pump I", 0, 88, 0, 0, 0, 0, 0, 66, 0, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Remote Repair Augmentor Pump I", 0, 18, 0, 0, 0, 0, 0, 13, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Remote Repair Augmentor Pump I", 0, 3, 0, 0, 0, 0, 0, 2, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Nanobot Accelerator Pump I", 0, 88, 0, 0, 0, 0, 0, 66, 0, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Nanobot Accelerator Pump I", 0, 18, 0, 0, 0, 0, 0, 13, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Nanobot Accelerator Pump I", 0, 4, 0, 0, 0, 0, 0, 3, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Salvage Tackle Pump I", 0, 88, 0, 0, 0, 0, 0, 66, 0, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Salvage Tackle Pump I", 0, 18, 0, 0, 0, 0, 0, 13, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Salvage Tackle Pump I", 0, 4, 0, 0, 0, 0, 0, 3, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Nanobot Accelerator Pump I", 0, 88, 0, 0, 0, 0, 0, 66, 0, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Nanobot Accelerator Pump I", 0, 18, 0, 0, 0, 0, 0, 13, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Nanobot Accelerator Pump I", 0, 4, 0, 0, 0, 0, 0, 3, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Trimark Armor Pump I", 0, 72, 0, 0, 0, 0, 0, 55, 0, 0, 83, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Trimark Armor Pump I", 0, 14, 0, 0, 0, 0, 0, 11, 0, 0, 17, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Trimark Armor Pump I", 0, 3, 0, 0, 0, 0, 0, 2, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Auxiliary Thrusters I", 0, 0, 0, 99, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 33, 0, 0));
        rigs.add(new Rig("Medium Auxiliary Thrusters I", 0, 0, 0, 20, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0));
        rigs.add(new Rig("Small Auxiliary Thrusters I", 0, 0, 0, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        rigs.add(new Rig("Large Cargohold Optimization I", 110, 0, 0, 0, 0, 0, 0, 0, 0, 0, 130, 0, 0, 0, 0, 75, 0, 0, 0));
        rigs.add(new Rig("Medium Cargohold Optimization I", 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 26, 0, 0, 0, 0, 15, 0, 0, 0));
        rigs.add(new Rig("Small Cargohold Optimization I", 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 3, 0, 0, 0));
        rigs.add(new Rig("Large Dynamic Fuel Valve I", 22, 0, 0, 33, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 55, 0, 0, 0));
        rigs.add(new Rig("Medium Dynamic Fuel Valve I", 4, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 0, 0, 0));
        rigs.add(new Rig("Small Dynamic Fuel Valve I", 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0));
        rigs.add(new Rig("Large Engine Thermal Shielding I", 66, 0, 0, 0, 0, 0, 0, 0, 0, 0, 83, 0, 0, 0, 0, 72, 0, 0, 0));
        rigs.add(new Rig("Medium Engine Thermal Shielding I", 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 17, 0, 0, 0, 0, 14, 0, 0, 0));
        rigs.add(new Rig("Small Engine Thermal Shielding I", 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 3, 0, 0, 0));
        rigs.add(new Rig("Large Hyperspatial Velocity Optimizer I", 0, 0, 0, 116, 78, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 79, 0, 0));
        rigs.add(new Rig("Medium Hyperspatial Velocity Optimizer I", 0, 0, 0, 23, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, 0));
        rigs.add(new Rig("Small Hyperspatial Velocity Optimizer I", 0, 0, 0, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0));
        rigs.add(new Rig("Large Low Friction Nozzle Joints I", 0, 0, 0, 99, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 33, 0, 0));
        rigs.add(new Rig("Medium Low Friction Nozzle Joints I", 0, 0, 0, 20, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0));
        rigs.add(new Rig("Small Low Friction Nozzle Joints I", 0, 0, 0, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0));
        rigs.add(new Rig("Large Polycarbon Engine Housing I", 110, 0, 0, 0, 0, 0, 0, 0, 0, 0, 123, 0, 0, 0, 0, 77, 0, 0, 0));
        rigs.add(new Rig("Medium Polycarbon Engine Housing I", 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 24, 0, 0, 0, 0, 15, 0, 0, 0));
        rigs.add(new Rig("Small Polycarbon Engine Housing I", 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 3, 0, 0, 0));
        rigs.add(new Rig("Large Warp Core Optimizer I", 0, 0, 0, 109, 78, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 69, 0, 0));
        rigs.add(new Rig("Medium Warp Core Optimizer I", 0, 0, 0, 22, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 0, 0));
        rigs.add(new Rig("Small Warp Core Optimizer I", 0, 0, 0, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0));
        rigs.add(new Rig("Large Drone Control Range Augmentor I", 0, 0, 44, 83, 72, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Drone Control Range Augmentor I", 0, 0, 9, 17, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Drone Control Range Augmentor I", 0, 0, 2, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Drone Durability Enhancer I", 0, 0, 88, 110, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 110, 0, 0, 0));
        rigs.add(new Rig("Medium Drone Durability Enhancer I", 0, 0, 18, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 0, 0, 0));
        rigs.add(new Rig("Small Drone Durability Enhancer I", 0, 0, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0));
        rigs.add(new Rig("Large Drone Mining Augmentor I", 0, 0, 94, 110, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 110, 0, 0, 0));
        rigs.add(new Rig("Medium Drone Mining Augmentor I", 0, 0, 19, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 0, 0, 0));
        rigs.add(new Rig("Small Drone Mining Augmentor I", 0, 0, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0));
        rigs.add(new Rig("Large Drone Repair Augmentor I", 0, 0, 44, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 110, 0, 0, 0));
        rigs.add(new Rig("Medium Drone Repair Augmentor I", 0, 0, 9, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 0, 0, 0));
        rigs.add(new Rig("Small Drone Repair Augmentor I", 0, 0, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0));
        rigs.add(new Rig("Large Drone Scope Chip I", 0, 0, 44, 83, 72, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Drone Scope Chip I", 0, 0, 9, 17, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Drone Scope Chip I", 0, 0, 2, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Drone Speed Augmentor I", 0, 0, 88, 83, 72, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Drone Speed Augmentor I", 0, 0, 18, 17, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Drone Speed Augmentor I", 0, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Sentry Damage Augmentor I", 0, 0, 103, 113, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 116, 0, 0, 0));
        rigs.add(new Rig("Medium Sentry Damage Augmentor I", 0, 0, 21, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 23, 0, 0, 0));
        rigs.add(new Rig("Small Sentry Damage Augmentor I", 0, 0, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0));
        rigs.add(new Rig("Large Stasis Drone Augmentor I", 0, 0, 114, 127, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 133, 0, 0, 0));
        rigs.add(new Rig("Medium Stasis Drone Augmentor I", 0, 0, 23, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 26, 0, 0, 0));
        rigs.add(new Rig("Small Stasis Drone Augmentor I", 0, 0, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0));
        rigs.add(new Rig("Large Emission Scope Sharpener I", 0, 0, 0, 0, 0, 44, 0, 0, 88, 0, 0, 0, 0, 0, 0, 110, 0, 0, 0));
        rigs.add(new Rig("Medium Emission Scope Sharpener I", 0, 0, 0, 0, 0, 9, 0, 0, 18, 0, 0, 0, 0, 0, 0, 22, 0, 0, 0));
        rigs.add(new Rig("Small Emission Scope Sharpener I", 0, 0, 0, 0, 0, 2, 0, 0, 3, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0));
        rigs.add(new Rig("Large Gravity Capacitor Upgrade I", 0, 0, 0, 0, 88, 0, 0, 0, 88, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Gravity Capacitor Upgrade I", 0, 0, 0, 0, 18, 0, 0, 0, 13, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Gravity Capacitor Upgrade I", 0, 0, 0, 0, 3, 0, 0, 0, 2, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Liquid Cooled Electronics I", 0, 0, 0, 0, 110, 44, 0, 0, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Liquid Cooled Electronics I", 0, 0, 0, 0, 22, 9, 0, 0, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Liquid Cooled Electronics I", 0, 0, 0, 0, 4, 2, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Memetic Algorithm Bank I", 0, 0, 0, 0, 110, 44, 0, 0, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Memetic Algorithm Bank I", 0, 0, 0, 0, 22, 9, 0, 0, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Memetic Algorithm Bank I", 0, 0, 0, 0, 4, 2, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Signal Disruption Amplifier I", 0, 0, 0, 0, 0, 44, 0, 0, 88, 0, 0, 0, 0, 0, 0, 110, 0, 0, 0));
        rigs.add(new Rig("Medium Signal Disruption Amplifier I", 0, 0, 0, 0, 0, 7, 0, 0, 15, 0, 0, 0, 0, 0, 0, 18, 0, 0, 0));
        rigs.add(new Rig("Small Signal Disruption Amplifier I", 0, 0, 0, 0, 0, 1, 0, 0, 3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0));
        rigs.add(new Rig("Large Inverted Signal Field Projector I", 0, 0, 0, 0, 0, 0, 0, 0, 66, 0, 99, 0, 0, 0, 0, 88, 0, 0, 0));
        rigs.add(new Rig("Medium Inverted Signal Field Projector I", 0, 0, 0, 0, 0, 0, 0, 0, 13, 0, 20, 0, 0, 0, 0, 18, 0, 0, 0));
        rigs.add(new Rig("Small Inverted Signal Field Projector I", 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 4, 0, 0, 0, 0, 3, 0, 0, 0));
        rigs.add(new Rig("Large Ionic Field Projector I", 0, 0, 0, 110, 110, 0, 0, 0, 66, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Ionic Field Projector I", 0, 0, 0, 22, 22, 0, 0, 0, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Ionic Field Projector I", 0, 0, 0, 4, 4, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Particle Dispersion Augmentor I", 0, 0, 0, 0, 0, 0, 0, 0, 44, 0, 83, 0, 0, 0, 0, 72, 0, 0, 0));
        rigs.add(new Rig("Medium Particle Dispersion Augmentor I", 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 17, 0, 0, 0, 0, 14, 0, 0, 0));
        rigs.add(new Rig("Small Particle Dispersion Augmentor I", 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 3, 0, 0, 0, 0, 3, 0, 0, 0));
        rigs.add(new Rig("Large Particle Projector Augmentor I", 0, 0, 0, 0, 88, 0, 0, 0, 66, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Particle Projector Augmentor I", 0, 0, 0, 0, 18, 0, 0, 0, 13, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Particle Projector Augmentor I", 0, 0, 0, 0, 3, 0, 0, 0, 2, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Signal Focusing Kit I", 0, 0, 0, 66, 55, 0, 0, 0, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Signal Focusing Kit I", 0, 0, 0, 13, 11, 0, 0, 0, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Signal Focusing Kit I", 0, 0, 0, 2, 2, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Targeting System Subcontroller I", 0, 0, 0, 110, 110, 0, 0, 0, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Targeting System Subcontroller I", 0, 0, 0, 22, 22, 0, 0, 0, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Targeting System Subcontroller I", 0, 0, 0, 4, 4, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Targeting Systems Stabilizer I", 0, 0, 0, 110, 110, 0, 0, 0, 66, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Targeting Systems Stabilizer I", 0, 0, 0, 22, 22, 0, 0, 0, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Targeting Systems Stabilizer I", 0, 0, 0, 4, 4, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Tracking Diagnostic Subroutines I", 0, 0, 0, 0, 88, 0, 0, 0, 66, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Tracking Diagnostic Subroutines I", 0, 0, 0, 0, 18, 0, 0, 0, 13, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Tracking Diagnostic Subroutines I", 0, 0, 0, 0, 3, 0, 0, 0, 2, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Ancillary Current Router I", 0, 0, 0, 248, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 66, 0, 259, 0));
        rigs.add(new Rig("Medium Ancillary Current Router I", 0, 0, 0, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 0, 52, 0));
        rigs.add(new Rig("Small Ancillary Current Router I", 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 10, 0));
        rigs.add(new Rig("Large Capacitor Control Circuit I", 0, 0, 0, 83, 0, 0, 0, 0, 0, 0, 0, 0, 22, 0, 0, 0, 0, 72, 0));
        rigs.add(new Rig("Medium Capacitor Control Circuit I", 0, 0, 0, 17, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 14, 0));
        rigs.add(new Rig("Small Capacitor Control Circuit I", 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 3, 0));
        rigs.add(new Rig("Large Egress Port Maximizer I", 0, 0, 0, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 44, 0, 72, 0));
        rigs.add(new Rig("Medium Egress Port Maximizer I", 0, 0, 0, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 14, 0));
        rigs.add(new Rig("Small Egress Port Maximizer I", 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 3, 0));
        rigs.add(new Rig("Large Powergrid Subroutine Maximizer I", 0, 0, 0, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 44, 0, 72, 0));
        rigs.add(new Rig("Medium Powergrid Subroutine Maximizer I", 0, 0, 0, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 14, 0));
        rigs.add(new Rig("Small Powergrid Subroutine Maximizer I", 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 3, 0));
        rigs.add(new Rig("Large Semiconductor Memory Cell I", 0, 0, 0, 165, 0, 0, 0, 0, 0, 0, 0, 0, 55, 0, 0, 0, 0, 165, 0));
        rigs.add(new Rig("Medium Semiconductor Memory Cell I", 0, 0, 0, 33, 0, 0, 0, 0, 0, 0, 0, 0, 11, 0, 0, 0, 0, 33, 0));
        rigs.add(new Rig("Small Semiconductor Memory Cell I", 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 7, 0));
        rigs.add(new Rig("Large Algid Energy Administrations Unit I", 0, 0, 0, 0, 88, 0, 0, 0, 0, 88, 110, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Algid Energy Administrations Unit I", 0, 0, 0, 0, 18, 0, 0, 0, 0, 18, 22, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Algid Energy Administrations Unit I", 0, 0, 0, 0, 3, 0, 0, 0, 0, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Energy Ambit Extension I", 0, 0, 0, 0, 88, 0, 0, 0, 0, 66, 99, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Energy Ambit Extension I", 0, 0, 0, 0, 16, 0, 0, 0, 0, 12, 18, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Energy Ambit Extension I", 0, 0, 0, 0, 3, 0, 0, 0, 0, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Energy Burst Aerator I", 0, 0, 0, 0, 88, 0, 0, 0, 0, 101, 125, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Energy Burst Aerator I", 0, 0, 0, 0, 16, 0, 0, 0, 0, 18, 23, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Energy Burst Aerator I", 0, 0, 0, 0, 3, 0, 0, 0, 0, 4, 5, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Energy Collision Accelerator I", 0, 0, 0, 0, 88, 0, 0, 0, 0, 114, 136, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Energy Collision Accelerator I", 0, 0, 0, 0, 16, 0, 0, 0, 0, 21, 25, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Energy Collision Accelerator I", 0, 0, 0, 0, 3, 0, 0, 0, 0, 4, 5, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Energy Discharge Elutriation I", 0, 0, 0, 0, 55, 0, 0, 0, 0, 22, 55, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Energy Discharge Elutriation I", 0, 0, 0, 0, 10, 0, 0, 0, 0, 4, 10, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Energy Discharge Elutriation I", 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Energy Locus Coordinator I", 0, 0, 0, 0, 88, 0, 0, 0, 0, 66, 99, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Energy Locus Coordinator I", 0, 0, 0, 0, 16, 0, 0, 0, 0, 12, 18, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Energy Locus Coordinator I", 0, 0, 0, 0, 3, 0, 0, 0, 0, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Energy Metastasis Adjuster I", 0, 0, 0, 0, 88, 0, 0, 0, 0, 66, 99, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Energy Metastasis Adjuster I", 0, 0, 0, 0, 16, 0, 0, 0, 0, 12, 18, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Energy Metastasis Adjuster I", 0, 0, 0, 0, 3, 0, 0, 0, 0, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Algid Hybrid Administrations Unit I", 0, 0, 0, 0, 88, 0, 88, 0, 0, 0, 110, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Algid Hybrid Administrations Unit I", 0, 0, 0, 0, 18, 0, 18, 0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Algid Hybrid Administrations Unit I", 0, 0, 0, 0, 3, 0, 3, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Hybrid Ambit Extension I", 0, 0, 0, 0, 88, 0, 66, 0, 0, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Hybrid Ambit Extension I", 0, 0, 0, 0, 18, 0, 13, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Hybrid Ambit Extension I", 0, 0, 0, 0, 3, 0, 2, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Hybrid Burst Aerator I", 0, 0, 0, 0, 88, 0, 101, 0, 0, 0, 125, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Hybrid Burst Aerator I", 0, 0, 0, 0, 18, 0, 20, 0, 0, 0, 25, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Hybrid Burst Aerator I", 0, 0, 0, 0, 3, 0, 4, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Hybrid Collision Accelerator I", 0, 0, 0, 0, 88, 0, 114, 0, 0, 0, 136, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Hybrid Collision Accelerator I", 0, 0, 0, 0, 18, 0, 23, 0, 0, 0, 28, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Hybrid Collision Accelerator I", 0, 0, 0, 0, 3, 0, 4, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Hybrid Discharge Elutriation I", 0, 0, 0, 0, 55, 0, 22, 0, 0, 0, 55, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Hybrid Discharge Elutriation I", 0, 0, 0, 0, 11, 0, 4, 0, 0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Hybrid Discharge Elutriation I", 0, 0, 0, 0, 2, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Hybrid Locus Coordinator I", 0, 0, 0, 0, 88, 0, 66, 0, 0, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Hybrid Locus Coordinator I", 0, 0, 0, 0, 18, 0, 13, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Hybrid Locus Coordinator I", 0, 0, 0, 0, 3, 0, 2, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Hybrid Metastasis Adjuster I", 0, 0, 0, 0, 88, 0, 66, 0, 0, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Hybrid Metastasis Adjuster I", 0, 0, 0, 0, 18, 0, 13, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Hybrid Metastasis Adjuster I", 0, 0, 0, 0, 3, 0, 2, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Bay Loading Accelerator I", 0, 0, 0, 125, 0, 0, 0, 0, 0, 0, 0, 0, 0, 101, 0, 0, 0, 88, 0));
        rigs.add(new Rig("Medium Bay Loading Accelerator I", 0, 0, 0, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 0, 18, 0));
        rigs.add(new Rig("Small Bay Loading Accelerator I", 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 3, 0));
        rigs.add(new Rig("Large Hydraulic Bay Thrusters I", 0, 0, 0, 110, 0, 0, 0, 0, 0, 0, 0, 0, 0, 44, 0, 0, 0, 110, 0));
        rigs.add(new Rig("Medium Hydraulic Bay Thrusters I", 0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 22, 0));
        rigs.add(new Rig("Small Hydraulic Bay Thrusters I", 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 4, 0));
        rigs.add(new Rig("Large Rocket Fuel Cache Partition I", 0, 0, 0, 110, 0, 0, 0, 0, 0, 0, 0, 0, 0, 58, 0, 0, 0, 110, 0));
        rigs.add(new Rig("Medium Rocket Fuel Cache Partition I", 0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0, 0, 0, 22, 0));
        rigs.add(new Rig("Small Rocket Fuel Cache Partition I", 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 4, 0));
        rigs.add(new Rig("Large Warhead Calefaction Catalyst I", 0, 0, 0, 136, 0, 0, 0, 0, 0, 0, 0, 0, 0, 114, 0, 0, 0, 88, 0));
        rigs.add(new Rig("Medium Warhead Calefaction Catalyst I", 0, 0, 0, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 23, 0, 0, 0, 18, 0));
        rigs.add(new Rig("Small Warhead Calefaction Catalyst I", 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 3, 0));
        rigs.add(new Rig("Large Warhead Flare Catalyst I", 0, 0, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 66, 0, 0, 0, 88, 0));
        rigs.add(new Rig("Medium Warhead Flare Catalyst I", 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 0, 0, 0, 18, 0));
        rigs.add(new Rig("Small Warhead Flare Catalyst I", 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 3, 0));
        rigs.add(new Rig("Large Warhead Rigor Catalyst I", 0, 0, 0, 110, 0, 0, 0, 0, 0, 0, 0, 0, 0, 44, 0, 0, 0, 110, 0));
        rigs.add(new Rig("Medium Warhead Rigor Catalyst I", 0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 22, 0));
        rigs.add(new Rig("Small Warhead Rigor Catalyst I", 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 4, 0));
        rigs.add(new Rig("Large Projectile Ambit Extension I", 0, 0, 0, 0, 88, 0, 0, 0, 0, 0, 99, 0, 0, 0, 66, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Projectile Ambit Extension I", 0, 0, 0, 0, 18, 0, 0, 0, 0, 0, 20, 0, 0, 13, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Projectile Ambit Extension I", 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 4, 0, 0, 0, 2, 0, 0, 0, 0));
        rigs.add(new Rig("Large Projectile Burst Aerator I", 0, 0, 0, 0, 88, 0, 0, 0, 0, 0, 125, 0, 0, 0, 101, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Projectile Burst Aerator I", 0, 0, 0, 0, 18, 0, 0, 0, 0, 0, 25, 0, 0, 0, 20, 0, 0, 0, 0));
        rigs.add(new Rig("Small Projectile Burst Aerator I", 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 6, 0, 0, 0, 4, 0, 0, 0, 0));
        rigs.add(new Rig("Large Projectile Collision Accelerator I", 0, 0, 0, 0, 88, 0, 0, 0, 0, 0, 136, 0, 0, 0, 114, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Projectile Collision Accelerator I", 0, 0, 0, 0, 18, 0, 0, 0, 0, 0, 28, 0, 0, 0, 23, 0, 0, 0, 0));
        rigs.add(new Rig("Small Projectile Collision Accelerator I", 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 6, 0, 0, 0, 4, 0, 0, 0, 0));
        rigs.add(new Rig("Large Projectile Locus Coordinator I", 0, 0, 0, 0, 88, 0, 0, 0, 0, 0, 99, 0, 0, 0, 66, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Projectile Locus Coordinator I", 0, 0, 0, 0, 18, 0, 0, 0, 0, 0, 20, 0, 0, 0, 13, 0, 0, 0, 0));
        rigs.add(new Rig("Small Projectile Locus Coordinator I", 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 4, 0, 0, 0, 2, 0, 0, 0, 0));
        rigs.add(new Rig("Large Projectile Metastasis Adjuster I", 0, 0, 0, 0, 88, 0, 0, 0, 0, 0, 99, 0, 0, 0, 66, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Projectile Metastasis Adjuster I", 0, 0, 0, 0, 18, 0, 0, 0, 0, 0, 20, 0, 0, 0, 13, 0, 0, 0, 0));
        rigs.add(new Rig("Small Projectile Metastasis Adjuster I", 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 4, 0, 0, 0, 2, 0, 0, 0, 0));
        rigs.add(new Rig("Large Anti-EM Screen Reinforcer I", 0, 0, 0, 0, 72, 0, 0, 0, 0, 0, 83, 44, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Anti-EM Screen Reinforcer I", 0, 0, 0, 0, 14, 0, 0, 0, 0, 0, 17, 9, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Anti-EM Screen Reinforcer I", 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Anti-Explosive Screen Reinforcer I", 0, 0, 0, 0, 72, 0, 0, 0, 0, 0, 83, 44, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Anti-Explosive Screen Reinforcer I", 0, 0, 0, 0, 14, 0, 0, 0, 0, 0, 17, 9, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Anti-Explosive Screen Reinforcer I", 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Anti-Kinetic Screen Reinforcer I", 0, 0, 0, 0, 72, 0, 0, 0, 0, 0, 83, 44, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Anti-Kinetic Screen Reinforcer I", 0, 0, 0, 0, 14, 0, 0, 0, 0, 0, 17, 9, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Anti-Kinetic Screen Reinforcer I", 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Anti-Thermal Screen Reinforcer I", 0, 0, 0, 0, 72, 0, 0, 0, 0, 0, 83, 44, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Anti-Thermal Screen Reinforcer I", 0, 0, 0, 0, 14, 0, 0, 0, 0, 0, 17, 9, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Anti-Thermal Screen Reinforcer I", 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Core Defence Capacitor Safeguard I", 0, 0, 0, 0, 55, 0, 0, 0, 0, 0, 66, 22, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Core Defence Capacitor Safeguard I", 0, 0, 0, 0, 11, 0, 0, 0, 0, 0, 13, 4, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Core Defence Capacitor Safeguard I", 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Core Defence Charge Economizer I", 0, 0, 0, 0, 77, 0, 0, 0, 0, 0, 72, 33, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Medium Core Defence Charge Economizer I", 0, 0, 0, 0, 15, 0, 0, 0, 0, 0, 14, 7, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Small Core Defence Charge Economizer I", 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0));
        rigs.add(new Rig("Large Core Defence Field Extender I", 0, 0, 0, 110, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 110, 0, 0, 44));
        rigs.add(new Rig("Medium Core Defence Field Extender I", 0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 0, 0, 9));
        rigs.add(new Rig("Small Core Defence Field Extender I", 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 2));
        rigs.add(new Rig("Large Core Defence Field Purger I", 0, 0, 0, 110, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 110, 0, 0, 44));
        rigs.add(new Rig("Medium Core Defence Field Purger I", 0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 0, 0, 9));
        rigs.add(new Rig("Small Core Defence Field Purger I", 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 2));
        rigs.add(new Rig("Large Core Defence Operational Solidifier I", 0, 0, 0, 110, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 110, 0, 0, 44));
        rigs.add(new Rig("Medium Core Defence Operational Solidifier I", 0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 0, 0, 9));
        rigs.add(new Rig("Small Core Defence Operational Solidifier I", 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 2));
        return rigs;
    }

    private static List<Construction> howManyRigsCanIMake(Rig invintory, List<Rig> rigs, Map<String, String> settings)
    {
        List<Construction> construction = new ArrayList<Construction>();
        for(Rig parts : rigs){
        	construction.add(invintory.howManyCanIMake(parts, settings));
        }

        return construction;
    }

    private static void outputConstructionToFile(List<Construction> construction, Map<String, String> settings)
        throws IOException
    {
        CSVWriter writer = new CSVWriter(new FileWriter("output.csv"), ',');
        for(Construction construct : construction)
        {
            String entryString = (new StringBuilder(String.valueOf(construct.getName()))).append("#").append(construct.getNumber()).toString();
            String[] entries = entryString.split("#");
            writer.writeNext(entries);
        }

        writer.close();
    }
}
