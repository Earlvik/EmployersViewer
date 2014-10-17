/**
 * Created by Виктор on 16.10.2014.
 */
$(document).ready(function(){
    $('#findEmployerForm').submit(function(event){
        var firstName = $('#firstName').val();
        var secondName = $('#secondName').val();
        var lastName = $('#lastName').val();
        $.ajax({
            url: "/find/",
            type: "GET",
            data: "firstName="+firstName+"&secondName="+secondName+"&lastName="+lastName,

        });


    });
});
function deleteEmployer(id) {
    $.ajax({
        url: "/delete",
        type: "POST",
        data: "employerId="+id,
        success: function(employer){
            var respContent = "";
            respContent+="Employer was deleted: ";
            respContent+= employer.firstName+" ";
            respContent+= employer.secondName+" ";
            respContent+= employer.lastName;
            $("#EmployerFromResponse").html(respContent);
            $(location).attr('href',"/");
        }
    });
    event.preventDefault();
}
