$(document).ready(function () {
    //load datatable plugin - table viewer
    
    var pathname = window.location.pathname;
    pathname = pathname.split("/");
    var pg_url = pathname[pathname.length - 2]+"/"+pathname[pathname.length - 1]
    console.log(pg_url);
    if(pg_url == "product_category/index.jsp"){
        $.ajax({
        url:ctx+"/CategoryController",
        type: "POST",
        data: {act : "view"},
        success:function(result){            
            $.each(result, function(index, value){
                $('#dataList tbody').append($("<tr>").append(
                        $('<td>').html(value.id),
                        $('<td>').html(value.category),
                        $('<td>').html(value.description),
                        $('<td>').html(value.created_at),
                        $('<td>').append(
                                    $('<div>').attr('class','btn-group').append(
                                        $('<a>').attr({
                                            href:ctx+'/CategoryController?act=edit&id='+value.id,
                                            class: 'btn btn-success'
                                        }).append(
                                            $('<i>').attr('class', 'far fa-edit')
                                        ),
                                        $('<a>').attr({
                                            href:ctx+'/CategoryController',
                                            class: 'btn btn-info'
                                        }).append(
                                            $('<i>').attr('class', 'fas fa-print')
                                        ),
                                        $('<form>').attr({
                                           method: 'get',
                                           action: ctx+'/CategoryController'
                                        }).append(
                                                $('<input>').attr({
                                                type: 'hidden',
                                                value: value.id,
                                                name: 'id'
                                              }),
                                              $('<input>').attr({
                                                type: 'hidden',
                                                value: 'delete',
                                                name: 'act'
                                              }),
                                              $('<button>').attr({
                                                  class: 'btn btn-danger category-delete',
                                                  type: 'submit'
                                              }).append(
                                                    $('<i>').attr('class', 'far fa-trash-alt')
                                                ),
                                            ),
                                        

                                    )
                                )
                        ));
            });
            datatables();
        }
    })
    }else if(pg_url == "products/index.jsp"){
        $.ajax({
            url:ctx+"/ProductController",
            type: "POST",
            data: {act : "view"},
            success: function(result){
                console.log(result);
            }
        })
    }
    else{
        datatables();
    }
    count = 1    
    $("#addAttributes").click(function(){
        $("#addCategory").attr('class','btn btn-primary');
        $(".attributes").append(
                $("<div>").attr({
                    class: 'form-group'
                }).append(
                        $("<label>").html("Attribute "+count),
                        $("<input>").attr({
                            name: 'attribute'+count,
                            type: 'text',
                            class: 'form-control'
                        })
            )
        )
        count++;
    });
    $(".category-form").one('mouseenter', function(e){
        $.ajax({
            method: 'get',
            data: {act : 'categories'},
            url: ctx+"/CategoryController",
            success: function(data){
                $.each(data, function(key, value){
                    console.log(key, value.id)
                    $(".category-form #category").append(
                            $("<option>").val(value.id).html(value.category),
                        )
                });
            }
        })
    });
    
    $("#category_id").change(function(){
        cat_id = $(this).val();
        product_attributes(cat_id);
    });
    cat_id = $("#category_id").val();
    product_attributes(cat_id);
    
    $('.product-category').change(function(){
        productCategoryId = $(this).val();
        console.log(productCategoryId);
        attributes = $('.attributes');
        attributes.empty()     //gt() is a selector method which specifies select index more than 0
//        let dishId = $('#productCategory').val();
        url = ctx+"/CatAttController";
        $.ajax({
            url: url,
            data: {'act': 'attribute', 'id': productCategoryId},
            method: 'post',
            cache: 'false',
            success: function (response) {
                $.each(response, function (key, attribute){
                    attributes.append(
                        $("<div>", { class: "form-group" }).append(
                                                            $("<label>",{text: attribute.category_attribute_name}).attr({style: "text-transform:capitalize"}),
                                                            $("<input>", {class: "form-control", type: "text"}).attr({name: attribute.id})
                                                        )
                    );
                });
            }
        });
    });
});

function datatables(){
    $('#dataList, table.order-list').DataTable({
        'lengthMenu': [[10, 25, 50, -1], [10, 25, 50, "All"]],
        dom: 'Bfrtip',
        language: {
            searchPlaceholder: "Search records",
            search: "",
        },
        buttons: [
            { extend: 'pdf',className: 'btn btn-primary glyphicon glyphicon-file' },
            { 
                extend: 'print', 
                exportOptions: {
                    columns: ':visible'
                },
                className: 'btn btn-primary glyphicon glyphicon-print' },
            { extend: 'colvis', className: 'btn btn-primary glyphicon glyphicon-print' },
            
        ],
        // columnDefs: [{
        //     targets: -1,
        //     visible: false
        // }]
    });
}
function product_attributes(cat_id){
    if (cat_id == 1){
            $(".fitness").removeClass("hidden");
            $(".cloth").addClass("hidden");
            $(".protein").addClass("hidden");
        }else if(cat_id == 2){
            $(".cloth").addClass("hidden");
            $(".fitness").addClass("hidden");
            $(".protein").removeClass("hidden");
        }else if(cat_id == 3){
            $(".protein").addClass("hidden");
            $(".fitness").addClass("hidden");
            $(".cloth").removeClass("hidden");
        }else{
            $(".fitness").addClass("hidden");
            $(".cloth").addClass("hidden");
            $(".protein").addClass("hidden");
        }
}