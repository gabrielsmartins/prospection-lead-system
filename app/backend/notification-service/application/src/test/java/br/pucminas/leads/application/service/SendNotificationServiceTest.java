package br.pucminas.leads.application.service;

import br.pucminas.leads.application.ports.out.ConfirmNotificationPort;
import br.pucminas.leads.application.ports.out.SendNotificationPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static br.pucminas.leads.application.support.NotificationSupport.defaultNotification;
import static org.mockito.Mockito.*;

class SendNotificationServiceTest {

    private SendNotificationService service;
    private List<SendNotificationPort> sendNotificationPorts;
    private ConfirmNotificationPort confirmNotificationPort;

    @BeforeEach
    public void setup() {
        this.sendNotificationPorts = new LinkedList<>();
        this.confirmNotificationPort = mock(ConfirmNotificationPort.class);
        this.service = new SendNotificationService(this.sendNotificationPorts, this.confirmNotificationPort);
    }

    @Test
    @DisplayName("Given Notification When Send Then Call All Ports")
    public void givenNotificationWhenSendThenCallAllPorts() {
        var mockPortOne = mock(SendNotificationPort.class);
        this.sendNotificationPorts.add(mockPortOne);

        var mockPortTwo = mock(SendNotificationPort.class);
        this.sendNotificationPorts.add(mockPortTwo);

        var notification = defaultNotification().build();
        this.service.send(notification);
        verify(mockPortOne, times(1)).send(notification);
        verify(mockPortTwo, times(1)).send(notification);
        verify(this.confirmNotificationPort, times(1)).confirm(notification);
    }

}