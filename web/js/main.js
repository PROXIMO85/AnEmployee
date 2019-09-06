var globBtnId='';
var globanEmployeeId=0;

function getEmployeeList() {
    $.ajax({
       url:'cs?action=getEmployeeList',
       type:'GET',
       dataType:'html',
       success: function (data) {
           $('#anemployeeTableId').html(data);

       }
    });
    
}

function createEmployee() {

    var Name= $('#nameId').val();
    var Surname= $('#surnameId').val();
    var Age= $('#ageId').val();
    var JobTitle= $('#jobtitleId').val();
    var Homecity= $('#homecityId').val();
    var Experience= $('#experienceId').val();


    var data={
        Name:Name,
        Surname:Surname,
        Age:Age,
        JobTitle:JobTitle,
        Homecity:Homecity,
        Experience:Experience



    };

    $.ajax({
        url:'cs?action=createEmployee',
        type:'POST',
        dataType:'text',
        data:data,
        complete:function (data) {
            alert('Employee was added successfully');
            getEmployeeList();

        }
    });

}

function editAnEmployee(anemployeeId) {
    globanEmployeeId=anemployeeId;
    $.ajax({
        url:'cs?action=getAnEmployeeById',
        type:'GET',
        data:'anemployeeId='+anemployeeId,
        dataType:'html',
        success:function (data) {
            $('#editemployeeDialogId').html(data);
            $('#editemployeeDialogId').dialog('open');
        }
    });
}

function updateAnEmployee() {
    var Name= $('#nameId1').val();
    var Surname= $('#surnameId1').val();
    var Age= $('#ageId1').val();
    var JobTitle= $('#jobtitleId1').val();
    var Homecity= $('#homecityId1').val();
    var Experience= $('#experienceId1').val();


    var data={
        Name:Name,
        Surname:Surname,
        Age:Age,
        JobTitle:JobTitle,
        Homecity:Homecity,
        Experience:Experience,
        anemployeeId:globanEmployeeId

    };

    $.ajax({
        url:'cs?action=updateAnEmployee',
        type:'POST',
        dataType:'text',
        data:data,
        complete:function (data) {
            alert('Information has changed');
            getEmployeeList();

        }
    });
}

function clickname(anemployeeId) {
    $.ajax({
        url:'cs?action=getAnEmployeeById',
        type:'GET',
        data:'anemployeeId='+anemployeeId,
        dataType:'html',
        success:function (data) {
            $('#clicknameDialogId').html(data);
            $('#clicknameDialogId').dialog('open');
        }
    });
}

function deleteAnEmployee(anemployeeId) {
    var isDelete=confirm('Delete An Employee?');


    if (isDelete==true){
        $.ajax({
            url:'cs?action=deleteAnEmployee',
            type:'POST',
            data:'anemployeeId='+anemployeeId,
            dataType:'text',
            success:function (data) {
                alert('Deleted');
                getEmployeeList();
            }
        });

    }else {
        alert('It could not be deleted');
    }
}
