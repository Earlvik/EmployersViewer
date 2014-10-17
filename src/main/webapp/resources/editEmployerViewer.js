/**
 * Created by Виктор on 16.10.2014.
 */
$(document).ready(function(){
    $('#editEmployerForm').submit(function(event){
        var id = $('#id').val();
        var firstName = $('#firstName').val();
        var secondName = $('#secondName').val();
        var lastName = $('#lastName').val();
        var age = $('#age').val();
        var experience = $('#experience').val();
        var description = $('#description').val();
        $.ajax({
            url: "/edit/"+id,
            type: "POST",
            data: "firstName="+firstName+"&secondName="+secondName+"&lastName="+lastName+
                "&age="+age+"&experience="+experience+"&description="+description,


            success: function(employer){
                var respContent = "";
                respContent+="Employer was edited: ";
                respContent+= employer.firstName+" ";
                respContent+= employer.secondName+" ";
                respContent+= employer.lastName;
                $("#EmployerFromResponse").html(respContent);
                $(location).attr('href',"/");
            }
        });
        event.preventDefault();

    });
});