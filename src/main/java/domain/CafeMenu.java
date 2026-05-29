package domain;

import java.time.LocalDate;

public class CafeMenu {

    private Long id;
    private String menuName;
    private String category;
    private Integer price;
    private LocalDate releaseDate;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {

        this.menuName = menuName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {

        this.category = category;
    }

    public Integer getPrice() {

        return price;
    }

    public void setPrice(Integer price) {

        this.price = price;
    }

    public LocalDate getReleaseDate() {

        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {

        this.releaseDate = releaseDate;
    }
}
