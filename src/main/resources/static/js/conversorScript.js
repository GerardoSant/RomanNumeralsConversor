function convert(isDecimal){
    var number = document.getElementById("numberInput").value;
    $('#errorAlert').addClass('hidden');
    $('#resultPanel').removeClass('hidden');
    ajaxConvertRequest(number,isDecimal);
}


function ajaxConvertRequest(number, isDecimal){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("result").innerHTML =
                this.responseText;
        } else if(this.status== 400) {
            document.getElementById("result").innerHTML = "Error";
            document.getElementById("errorMessage").innerHTML = this.responseText;
            $('#errorAlert').removeClass('hidden');
        }
    };
    var url;
    if (isDecimal){
        url=window.location.href + "/decimalToRoman?number=" + number;
    } else{
        url=window.location.href + "/romanToDecimal?number=" + number
    }
    xhttp.open("GET", url , true);
    xhttp.send();
}