function main_plan() {
    const all_sections = document.getElementsByTagName("section");
    let sections_name = [];

    for (let i = 0; i < all_sections.length; i++) {
        let section = all_sections[i];
        let section_name = section.getAttribute("name");
        if (section_name != null) {
            sections_name.push(section_name);
        }
    }


    const section_element = document.getElementById("plan");
    section_element.setAttribute("data-transition", "fade-in fade-out");

    const h2_element = document.createElement("h2");
    h2_element.appendChild(document.createTextNode("Plan"));

    section_element.appendChild(h2_element);

    const ul_element = document.createElement("ul");
    section_element.appendChild(ul_element);

    const outline_div = document.createElement("div");
    outline_div.setAttribute("data-id", "menu");
    outline_div.setAttribute("class", "outline");

    ul_element.appendChild(outline_div);

    for (let i = 0; i < sections_name.length; i++) {
        const item_div = document.createElement("div");
        item_div.setAttribute("class", "item");
        outline_div.appendChild(item_div);

        const a_element = document.createElement("a");
        a_element.setAttribute("href", "#/ch".concat(i + 1));

        const chap_title = document.createTextNode(sections_name[i]);
        a_element.appendChild(chap_title);

        item_div.appendChild(a_element);
    }

    const p_element = document.createElement("p");
    section_element.appendChild(p_element);
    p_element.setAttribute("style", "font-size: 25px !important  ;");

    const a1_element = document.createElement("a");
    a1_element.setAttribute("href", "#/plan");
    const plan_title = document.createTextNode("Retour au plan");
    a1_element.appendChild(plan_title);
    p_element.appendChild(a1_element);

    const tiret = document.createTextNode(" - ");
    p_element.appendChild(tiret);

    const a2_element = document.createElement("a");
    a2_element.setAttribute("href", "#");
    const home = document.createTextNode("Retour à l'accueil");
    a2_element.appendChild(home);
    p_element.appendChild(a2_element);

}

function at_begin_section() {
    const all_sections = document.getElementsByTagName("section");
    let sections_name = [];

    for (let i = 0; i < all_sections.length; i++) {
        let section = all_sections[i];
        let section_name = section.getAttribute("name");
        if (section_name != null) {
            sections_name.push(section_name);
        }
    }

    for (let j = 0; j < sections_name.length; j++) {
        const section_element = document.getElementById("ch".concat(j + 1));
        section_element.setAttribute("data-transition", "fade-in fade-out");

        const h2_element = document.createElement("h2");
        h2_element.appendChild(document.createTextNode("Plan"));

        section_element.appendChild(h2_element);

        const ul_element = document.createElement("ul");
        section_element.appendChild(ul_element);

        const outline_div = document.createElement("div");
        outline_div.setAttribute("data-id", "menu");
        outline_div.setAttribute("class", "outline");

        ul_element.appendChild(outline_div);

        for (let i = 0; i < sections_name.length; i++) {
            const item_div = document.createElement("div");
            if (i == j) item_div.setAttribute("class", "item actif-item");
            else item_div.setAttribute("class", "item");
            outline_div.appendChild(item_div);

            const a_element = document.createElement("a");
            a_element.setAttribute("href", "#/ch".concat(i + 1));

            const chap_title = document.createTextNode(sections_name[i]);
            a_element.appendChild(chap_title);

            item_div.appendChild(a_element);
        }

        const p_element = document.createElement("p");
        section_element.appendChild(p_element);
        p_element.setAttribute("style", "font-size: 25px !important  ;");

        const a1_element = document.createElement("a");
        a1_element.setAttribute("href", "#/plan");
        const plan_title = document.createTextNode("Retour au plan");
        a1_element.appendChild(plan_title);
        p_element.appendChild(a1_element);

        const tiret = document.createTextNode(" - ");
        p_element.appendChild(tiret);

        const a2_element = document.createElement("a");
        a2_element.setAttribute("href", "#");
        const home = document.createTextNode("Retour à l'accueil");
        a2_element.appendChild(home);
        p_element.appendChild(a2_element);
    }
}

main_plan();
at_begin_section();
