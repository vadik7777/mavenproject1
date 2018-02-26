function send(){
    if ($("#family").val() == "" && $("#name").val() == "" && $("#lastname").val() == "" && $("#city").val() == "" &&
            $("#marka").val() == "" && $("#model").val() == "" && $("#nomer").val() == "") {
        $("#response").empty();
        $("#response").append("Заполните хотя бы одно из полей.");
        return;
    }
    var text = 'family=' + $("#family").val() + "&" + 'name=' + $("#name").val() + "&" +
            'lastname=' + $("#lastname").val() + "&" + 'city=' + $("#city").val() + "&" +
            'marka=' + $("#marka").val() + "&" + 'model=' + $("#model").val() + "&" +
            'nomer=' + $("#nomer").val();
    $.ajax({
        type: "post",
        url: "/mavenproject1/find",
        data: text,
        success: function (html) {
            $("#response").empty();
            $("#response").append(html);
        }
    });
}


