package com.glyk.heos.vo;

import java.util.List;

public class DeleteImageList {
    private List<Long>  deletedocList;
    private List<Long>  deleteShowImgList;
    private List<Long>  deletedetailImgList;

    public DeleteImageList(List<Long> deletedocList, List<Long> deleteShowImgList, List<Long> deletedetailImgList) {
        this.deletedocList = deletedocList;
        this.deleteShowImgList = deleteShowImgList;
        this.deletedetailImgList = deletedetailImgList;
    }

    public List<Long> getDeletedocList() {
        return deletedocList;
    }

    public void setDeletedocList(List<Long> deletedocList) {
        this.deletedocList = deletedocList;
    }

    public List<Long> getDeleteShowImgList() {
        return deleteShowImgList;
    }

    public void setDeleteShowImgList(List<Long> deleteShowImgList) {
        this.deleteShowImgList = deleteShowImgList;
    }

    public List<Long> getDeletedetailImgList() {
        return deletedetailImgList;
    }

    public void setDeletedetailImgList(List<Long> deletedetailImgList) {
        this.deletedetailImgList = deletedetailImgList;
    }
}
