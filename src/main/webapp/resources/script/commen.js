$(document).ready(function() {
    $(".search_cont ul.tab li.lnb").on('click', function() {
        let index = $(".search_cont ul.tab li.lnb").index(this);
      
        $('.search_cont ul.tab li.lnb').removeClass('on');
        $(this).addClass('on');
        
        $('.search_cont .tab_content').hide();
        $('.search_cont .tab_content:eq(' + index + ')').show();
    });

    $('.search_cont .tab_content').hide();
    $('.search_cont .tab_content:first').show();

    
    $(".icheck_sm_wrap input[type='checkbox']").change(function() {
        let checkboxId = $(this).attr('id');
        let checkboxLabel = $("label[for='" + checkboxId + "']").text();
        let $tagContainer = $(".tag_gnb");

        if ($(this).is(':checked')) {
            if (!$tagContainer.find(`.tag[data-id='${checkboxId}']`).length) {
                $tagContainer.append(`
                    <div class="tag" data-id="${checkboxId}">
                        ${checkboxLabel}
                        <span class="close-btn"></span>
                    </div>
                `);
            }
        } else {
            $tagContainer.find(`.tag[data-id='${checkboxId}']`).remove();
        }
    });

    $(document).on('click', '.tag .close-btn', function() {
        let $tag = $(this).closest('.tag');
        let checkboxId = $tag.data('id');
        $(`#${checkboxId}`).prop('checked', false).trigger('change');
        $tag.remove();
    });

    $(".reset").click(function() {
        $(".icheck_sm_wrap input[type='checkbox']").prop('checked', false);
        $(".tag_gnb").empty();
    });


    
});