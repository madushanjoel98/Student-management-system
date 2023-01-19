/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
 function branch() {
                $("#branch").empty();
                $.getJSON('<%=request.getContextPath()%>/cours.jsp?action=1', function (data) {
                    var select = document.getElementById("branch");

                    for (var i = 0; i < data.length; i++) {

                        var option = document.createElement("option");

                        option.text = data[i].name;
                        option.value = data[i].branch_id;
                        select.add(option);
                    }

                });
            }
            function courses() {
                $("#course").empty();
                $.getJSON('<%=request.getContextPath()%>/cours.jsp?action=2', function (data) {
                    var select = document.getElementById("course");

                    for (var i = 0; i < data.length; i++) {

                        var option = document.createElement("option");

                        option.text = data[i].course_name;
                        option.value = data[i].Course_ID;
                        select.add(option);
                    }

                });
            }

            function load_name() {
                var sid = document.getElementById("sid").value;
                $("#name").empty();
                $.getJSON('<%=request.getContextPath()%>/cours.jsp?action=3&sid=' + sid, function (data) {
                    //  let name = document.getElementById("name");
                    if (data === null) {
                        document.getElementById("wr").hidden = false;
                        document.getElementById("btn").disabled = true;
                    } else {
                        document.getElementById("wr").hidden = true;
                        document.getElementById("btn").disabled = false;
                        var names = data.first_name + " " + data.last_name;
                        //alert(names)

                        document.getElementById("name").innerHTML = names;
                    }
                });
            }

            function batching() {
                var cr = document.getElementById("course").value;
                var br = document.getElementById("branch").value;
                $("#batch").empty();

                $.getJSON('<%=request.getContextPath()%>/cours.jsp?action=4&br=' + br + '&cr=' + cr, function (data) {
                    var select = document.getElementById("batch");

                    for (var i = 0; i < data.length; i++) {
                        console.log(data);
                        var option = document.createElement("option");

                        option.text = data[i].batch_name;
                        option.value = data[i].Batch_NO;
                        select.add(option);
                    }

                });
            }

         function form_validation() {
                var cr = document.getElementById("course").value;
                var br = document.getElementById("branch").value;
                
            
            }

