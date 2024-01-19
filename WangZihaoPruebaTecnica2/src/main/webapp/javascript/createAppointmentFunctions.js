var provinceValue = document.getElementById("province").value;

function getProvince() {
    provinceValue = document.getElementById("province").value;
    $.ajax({
        type: "POST",
        url: "createAppointment.jsp",
        data: {provinceValue: provinceValue},
        success: function (data) {

            var tempDiv = document.createElement("div");
            tempDiv.innerHTML = data;

            var officeOptions = tempDiv.querySelector("#office").innerHTML;

            var officeSelect = document.getElementById("office");
            officeSelect.innerHTML = officeOptions;
        },
        error: function (xhr, status, error) {
            console.error("Error en la peticion Ajax:", status, error);
        }
    });

}

document.addEventListener("DOMContentLoaded", function () {
    getProvince();
});
