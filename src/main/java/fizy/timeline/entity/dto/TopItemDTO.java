package fizy.timeline.entity.dto;

public class TopItemDTO {
    public TopItemDTO(String name, int playCount) {
        this.name = name;
        this.playCount = playCount;
    }

    private String name;
    private int playCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }
}
