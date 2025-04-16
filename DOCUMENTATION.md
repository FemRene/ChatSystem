# ChatSystem Documentation

## Table of Contents
- [Introduction](#introduction)
- [Installation](#installation)
- [Configuration](#configuration)
- [Permissions](#permissions)
- [Commands](#commands)
- [Features](#features)
- [API](#api)
- [Troubleshooting](#troubleshooting)
- [FAQ](#faq)

## Introduction
ChatSystem is a lightweight yet powerful chat enhancement plugin for Bukkit/Spigot/Paper Minecraft servers. It provides features like user mentions, custom chat formatting, RGB/HEX color support, and integration with LuckPerms for prefix/suffix handling.

## Installation
1. Download the latest release from [GitHub](https://github.com/FemRene/ChatSystem/releases/latest/download/ChatSystem.jar)
2. Place the JAR file in your server's `plugins` folder
3. Restart your server or use a plugin manager to load the plugin
4. The plugin will generate a default configuration file that you can customize

### Dependencies
- **Required**: Paper/Spigot/Bukkit 1.20.x
- **Optional but recommended**: LuckPerms (for prefix/suffix support)

## Configuration
The plugin uses a configuration file located at `plugins/ChatSystem/config.yml`. Below are all available configuration options:

| Option | Default Value | Description |
|--------|---------------|-------------|
| arrow | `<#555555>»` | The arrow symbol used in chat messages |
| msg | `%prefix %arrow <#AAAAAA>%player %suffix: <reset>%message` | The format for chat messages |
| mentionMessage | `<#55FFFF>@%player<reset>` | The format for mentioned players |
| useMetaKeyAsPrefix | `false` | Whether to use a meta key for prefix instead of LuckPerms default |
| metaPrefixString | `META-KEY` | The meta key to use for prefix if useMetaKeyAsPrefix is true |
| useMetaKeyAsSuffix | `false` | Whether to use a meta key for suffix instead of LuckPerms default |
| metaSuffixString | `META-KEY` | The meta key to use for suffix if useMetaKeyAsSuffix is true |
| pingSound | `true` | Whether to play a sound when a player is mentioned |

### Message Format Placeholders
- `%prefix` - Player's prefix from LuckPerms
- `%suffix` - Player's suffix from LuckPerms
- `%player` - Player's name
- `%message` - The message content
- `%arrow` - The arrow symbol defined in config

### Color Codes
The plugin supports both traditional Minecraft color codes (using & or §) and modern MiniMessage format for RGB/HEX colors.

For HEX colors, use the format: `<#RRGGBB>` (e.g., `<#FF5500>` for orange)

For gradients and advanced formatting, refer to the [MiniMessage documentation](https://docs.advntr.dev/minimessage/format.html)

## Permissions
| Permission | Description |
|------------|-------------|
| `chat.write` | Allows a player to write in chat |
| `chat.important` | Makes the player's messages stand out with empty lines before and after |
| `chatsystem.reload` | Allows use of the reload command |

## Commands
| Command | Permission | Description |
|---------|------------|-------------|
| `/creload` | `chatsystem.reload` | Reloads the plugin configuration |

## Features

### User Mentions
Players can mention other players in chat by typing their username. The mentioned player will:
- See their name highlighted in the configured color
- Hear a notification sound (if enabled in config)

Example: `Hello @PlayerName, how are you?`

### Custom Chat Format
The plugin allows for complete customization of chat message format through the configuration file.

### RGB/HEX Color Support
Full support for RGB/HEX colors and gradients using the MiniMessage format.

### LuckPerms Integration
The plugin integrates with LuckPerms to display player prefixes and suffixes in chat.

### Important Users
Players with the `chat.important` permission will have their messages displayed with empty lines before and after, making them stand out in chat.

## API
Currently, the plugin does not provide a public API for other plugins to use. This feature is planned for future releases.

## Troubleshooting

### Common Issues

#### Messages Not Showing
- Ensure players have the `chat.write` permission
- Check if the message format in config is correct
- Verify that LuckPerms is properly installed if you're using prefix/suffix

#### Colors Not Working
- Make sure you're using the correct format for colors
- For HEX colors, use `<#RRGGBB>` format
- For traditional colors, use `&` or `§` followed by the color code

#### Mentions Not Working
- Ensure the player name is spelled exactly right
- Check if pingSound is enabled in config

#### Reload Command Not Working
- Verify that the player has the `chatsystem.reload` permission
- Check console for any error messages

## FAQ

### Q: Does this plugin work with other chat plugins?
A: ChatSystem may conflict with other chat plugins that modify the chat format. It's recommended to use only one chat formatting plugin at a time.

### Q: Can I use emojis in chat?
A: The plugin doesn't currently support emojis natively, but you can use Unicode characters in your messages.

### Q: How do I create a gradient color?
A: Use the MiniMessage format: `<gradient:#FF0000:#0000FF>Your text here</gradient>` for a red-to-blue gradient.

### Q: Does this plugin support multiple languages?
A: The plugin doesn't have built-in language support, but you can customize all messages in the config file.