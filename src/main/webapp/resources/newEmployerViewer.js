/**
 * Created by Виктор on 16.10.2014.
 */
$(document).ready(function(){
    $('#newEmployerForm').submit(function(event){
        var firstName = $('#firstName').val();
        var secondName = $('#secondName').val();
        var lastName = $('#lastName').val();
        var age = $('#age').val();
        var experience = $('#experience').val();
        var description = $('#description').val();
        $.ajax({
            url: "/add",
            type: "POST",
            data: "firstName="+firstName+"&secondName="+secondName+"&lastName="+lastName+
                "&age="+age+"&experience="+experience+"&description="+description,


            success: function(employer){
                var respContent = "";
                respContent+="Employer was created: ";
                respContent+= employer.firstName+" ";
                respContent+= employer.secondName+" ";
                respContent+= employer.lastName;
                $("#EmployerFromResponse").html(respContent);
                setTimeout($(location).attr('href',"/"),3000);
            },
            error: function(e){
                alert('Error: '+e);
            }
        });
        event.preventDefault();
    });
});