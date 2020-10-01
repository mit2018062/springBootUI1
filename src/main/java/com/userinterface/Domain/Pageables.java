package com.userinterface.Domain;

public class Pageables {
    private Sorted sort;
    private int pageNumber;
    private int pageSize;
    private int offset;
    private boolean paged; 
    private boolean unpaged;
    
	public boolean isUnpaged() {
		return unpaged;
	}
	public void setUnpaged(boolean unpaged) {
		this.unpaged = unpaged;
	}
	public boolean isPaged() {
		return paged;
	}
	public void setPaged(boolean paged) {
		this.paged = paged;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Sorted getSort() {
		return sort;
	}
	public void setSort(Sorted sort) {
		this.sort = sort;
	}
    
    
}