package API.Pojo.StarWars;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class StarshipsPojo {

    private int count;
    private String next;
    private String previous;
    private List<SWResultsPojo> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<SWResultsPojo> getResults() {
        return results;
    }

    public void setResults(List<SWResultsPojo> results) {
        this.results = results;
    }
}
