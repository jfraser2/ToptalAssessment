package com.toptal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ChangeTypeCounter {
	
	private List<ChangeTypeCount> elementCounterList = new ArrayList<>();
	
	public ChangeTypeCounter() {
		
	}
	
	public void addElement(Integer elementName) {

        Optional<ChangeTypeCount> foundElement = elementCounterList.stream()
            .filter(elementCount -> elementCount.getChangeType().equals(elementName))
            .findFirst();

        if (foundElement.isPresent()) {
        	ChangeTypeCount elementCount = foundElement.get();
        	elementCount.setCount(elementCount.getCount() + 1);
//            System.out.println("Found Element: " + foundElement.get().getElementName());
        } else {
        	elementCounterList.add(new ChangeTypeCount(elementName, 1));
//            System.out.println("Element not found.");
        }
		
	}
	
    public void dumpChangeDescending() {
    	
        // Dump in descending order
    	Comparator<ChangeTypeCount> reverseComparator = Comparator.comparing(ChangeTypeCount::getChangeType).reversed();    	
//    	Comparator<ChangeTypeCount> reverseComparator = Comparator.comparing(ChangeTypeCount::getChangeType);    	
        List<ChangeTypeCount> changeList = elementCounterList.stream()
        	.sorted(reverseComparator)	
            .collect(Collectors.toList());
        
		System.out.println();
		System.out.println();
        
        for(ChangeTypeCount aRec : changeList) {
        	System.out.println(aRec.toString());
        }

        this.elementCounterList.clear();
        
    }
	
	

}
