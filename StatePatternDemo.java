// State Interface
interface State {
    void handleRequest();
}

// Concrete State Classes
class DraftState implements State {
    @Override
    public void handleRequest() {
        System.out.println("Document is in Draft state. You can edit the document.");
    }
}

class ModerationState implements State {
    @Override
    public void handleRequest() {
        System.out.println("Document is in Moderation state. It is under review.");
    }
}

class PublishedState implements State {
    @Override
    public void handleRequest() {
        System.out.println("Document is in Published state. It is live now.");
    }
}

// Context Class
class Document {
    private State state;

    public Document() {
        // Initial state is Draft
        this.state = new DraftState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void applyState() {
        this.state.handleRequest();
    }
}

// Client Class
public class StatePatternDemo {
    public static void main(String[] args) {
        Document document = new Document();

        document.applyState();

        document.setState(new ModerationState());
        document.applyState();

        document.setState(new PublishedState());
        document.applyState();
    }
}
