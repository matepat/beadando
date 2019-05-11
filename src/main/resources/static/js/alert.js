function deleteNotification(id){
    //var id = /*[[${question.getId()}]]*/ '-1';
    swal({
        title: "Biztos hogy törölni szeretnéd?",
        text: "",
        icon: "warning",
        buttons: {
            cancel: "Mégse",
            delete: {
                text: "Igen",
                value: "del",
            },
        }
    })
        .then((value) =>{
        if(value == "del")
    window.location = '/kurzus/delete/' + id;
})
}