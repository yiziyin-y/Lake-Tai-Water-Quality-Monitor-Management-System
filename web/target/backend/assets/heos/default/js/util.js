//剔除为空字符
function EliminateUndefined(value) {

    if(value == undefined || value == null){
        value = " ";
    }

    return value;
}
//检验手机号
function cheackPhone(phone) {
    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
    if (!myreg.test(poneInput)) {
        return false;
    } else {
        return true;
    }
}
//检验email
function cheackEmail(email) {

    var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
    var isEmail = reg.test(email);
    return isEmail;
}
//删除展示图片
function deleteShowImage(index, event) {

    $(event).parent().remove();
    store.state.showImgList[index] = null;

}

//删除详情图片
function deleteDetailImage(index, event) {

    $(event).parent().remove();
    store.state.detailImgList[index] = null;

}

//删除文件
function deleteupFile(index, event) {
    $(event).parent().remove();
    store.state.fileList[index] = null;

}


//删除编辑展示图片
function deleteEditShowImage(index, event) {

    $(event).parent().remove();
    store.state.showImgList[index] = null;

}

//删除编辑详情图片
function deleteEidtDetailImage(index, event) {

    $(event).parent().remove();
    store.state.detailImgList[index] = null;

}

//删除编辑文件
function deleteEditupFile(index, event) {
    $(event).parent().remove();
    store.state.fileList[index] = null;

}
function deleteRegisterImage(index, event) {
    $(event).parent().remove();
    store.state.cretList[index] = null;
}