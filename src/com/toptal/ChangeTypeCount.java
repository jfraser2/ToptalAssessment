package com.toptal;

public class ChangeTypeCount {
	private int changeType;
    private int count;

    public ChangeTypeCount(int changeType, int count) {
        this.changeType = changeType;
        this.count = count;
    }

	
    @Override
    public String toString() {
        return "(" + this.changeType + ": " + this.count + ")";
    }


	public int getChangeType() {
		return changeType;
	}


	public void setChangeType(int changeType) {
		this.changeType = changeType;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}
	

}
